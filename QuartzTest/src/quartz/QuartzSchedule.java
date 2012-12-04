package quartz;

import com.google.gson.Gson;
import com.google.inject.Guice;
import com.google.inject.Injector;
import org.quartz.*;
import org.quartz.impl.calendar.AnnualCalendar;
import org.quartz.impl.calendar.WeeklyCalendar;

import javax.inject.Inject;

import java.io.*;
import java.util.*;
import java.util.Calendar;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;
import static org.quartz.CronScheduleBuilder.*;

/**
 * Date: 2012/06/22
 * <p/>
 * The source, with you may it be old master.
 */
public class QuartzSchedule {

   public static void main(String[] args) {


      Event event = new Event("1000", "dailyreminder");
      List<String> calendars = new ArrayList<String>();
      calendars.add("weeklyCalendar");
      calendars.add("monthlyCalendar");

      event.setCalendars(calendars);

      Gson gson = new Gson();

      System.out.println(gson.toJson(event));

      Injector injector = Guice.createInjector(new QuartzModule());

      Scheduler scheduler = injector.getInstance(Scheduler.class);
      try {
         scheduler.getListenerManager().addSchedulerListener(new QuartzScheduleListener(scheduler));
         scheduler.start();
      } catch (SchedulerException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
      QuartzSchedule qs = injector.getInstance(QuartzSchedule.class);
      qs.loadHolidayCalendars();


      Event eventRequest = new Event("1000", "registration");
      qs.scheduleEvent(eventRequest);

      eventRequest = new Event("1001", "dailyreminder", "08:36");
      qs.scheduleEvent(eventRequest);

      eventRequest.setTimeAsGmt("08:38");
      qs.scheduleEvent(eventRequest);

   }

   private AnnualCalendar loadHolidayCalendars() {
      //new years day 01/01
      //good friday 06/04 - not fixed
      //family day 09/04 - not fixed
      //freedom day 27/04
      //workers day 01/05
      //youth day 16/06
      //national womens day 09/08
      //heritage day 24/09
      //day of reconciliation 17/12
      //christmas day 25/12
      //day of goodwill 26/12

      //These days should be loaded once
      AnnualCalendar saHolidayCalendar = new AnnualCalendar();

      ArrayList<Calendar> excludedHolidays = new ArrayList<Calendar>();
      Calendar cal = Calendar.getInstance();
      cal.set(Calendar.DAY_OF_MONTH, 1);
      cal.set(Calendar.MONTH, Calendar.JANUARY);
      excludedHolidays.add(cal);

      cal = Calendar.getInstance();
      cal.set(Calendar.DAY_OF_MONTH, 6);
      cal.set(Calendar.MONTH, Calendar.APRIL);
      excludedHolidays.add(cal);

      cal = Calendar.getInstance();
      cal.set(Calendar.DAY_OF_MONTH, 9);
      cal.set(Calendar.MONTH, Calendar.APRIL);
      excludedHolidays.add(cal);

      cal = Calendar.getInstance();
      cal.set(Calendar.DAY_OF_MONTH, 27);
      cal.set(Calendar.MONTH, Calendar.APRIL);
      excludedHolidays.add(cal);

      cal = Calendar.getInstance();
      cal.set(Calendar.DAY_OF_MONTH, 1);
      cal.set(Calendar.MONTH, Calendar.MAY);
      excludedHolidays.add(cal);

      cal = Calendar.getInstance();
      cal.set(Calendar.DAY_OF_MONTH, 16);
      cal.set(Calendar.MONTH, Calendar.JUNE);
      excludedHolidays.add(cal);

      cal = Calendar.getInstance();
      cal.set(Calendar.DAY_OF_MONTH, 9);
      cal.set(Calendar.MONTH, Calendar.AUGUST);
      excludedHolidays.add(cal);

      cal = Calendar.getInstance();
      cal.set(Calendar.DAY_OF_MONTH, 24);
      cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
      excludedHolidays.add(cal);

      cal = Calendar.getInstance();
      cal.set(Calendar.DAY_OF_MONTH, 17);
      cal.set(Calendar.MONTH, Calendar.DECEMBER);
      excludedHolidays.add(cal);

      cal = Calendar.getInstance();
      cal.set(Calendar.DAY_OF_MONTH, 25);
      cal.set(Calendar.MONTH, Calendar.DECEMBER);
      excludedHolidays.add(cal);

      cal = Calendar.getInstance();
      cal.set(Calendar.DAY_OF_MONTH,26);
      cal.set(Calendar.MONTH, Calendar.DECEMBER);
      excludedHolidays.add(cal);


      saHolidayCalendar.setDaysExcluded(excludedHolidays);
//      try {
//         scheduler.addCalendar("SAHolidays",saHolidayCalendar, true ,true);
//      } catch (SchedulerException e) {
//         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//      }
//
//      List<Calendar> list = saHolidayCalendar.getDaysExcluded();
//      for(Calendar c : list) {
//         System.out.println(c.getTime());
//      }
      return saHolidayCalendar;
   }

   private Event extractEvent(Event eventRequest) {
      Event event = null;
      try {
         BufferedReader br  = new BufferedReader(new FileReader(new File("./QuartzTest/conf/events/" + eventRequest.getEventType() + ".json")));
         String tmp;
         String s = "";
         while ((tmp=br.readLine())!=null) {
            s += tmp;
         }
         Gson gson = new Gson();
         event = gson.fromJson(s, Event.class);
         event.setUserId(eventRequest.getUserId());
         event.setTimeAsGmt(eventRequest.getTimeAsGmt());
         if (eventRequest.getTimeAsGmt()!=null) {
            event.setTimeAsGmt(eventRequest.getTimeAsGmt());
         }

      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException e) {
         e.printStackTrace();
      }
      return event;
   }


   public enum SCHEDULE_TYPE {
      DAILY, WEEKLY, ONCE, MONTHLY
   }

   private Scheduler scheduler;

   private Set<String> calendars;

   @Inject
   public QuartzSchedule(Scheduler scheduler) {
      this.scheduler = scheduler;

      //setup standard calendars
      try {
         this.scheduler.addCalendar("weeklyCalendar", new WeeklyCalendar(), true, true);
         this.scheduler.addCalendar("saHolidayCalendar", loadHolidayCalendars(), true, true);
      } catch (SchedulerException e) {
         e.printStackTrace();
      }
   }

   public void scheduleEvent(Event eventRequest) {
      Event event = extractEvent(eventRequest);
      int hour = 7;
      int min = 0;
      if (event.getTimeAsGmt()!=null) {
         String [] hourMin = event.getTimeAsGmt().split(":");
         hour = Integer.parseInt(hourMin[0]);
         min = Integer.parseInt(hourMin[1]);
      }

      try {
         Class cls = Class.forName(event.getJobType());

         JobDetail job = newJob(cls)
                 .withIdentity(event.getEventType() + "." + event.getUserId(), event.getContext())
                 .usingJobData("userId", event.getUserId()).build();

         TriggerBuilder tb = newTrigger().withIdentity(event.getEventType() + "." + event.getUserId(), event.getContext());
         if (event.getFrequency().equalsIgnoreCase("once")) {
            tb.startNow();
         } else if (event.getFrequency().equalsIgnoreCase("daily")) {
            tb.withSchedule(dailyAtHourAndMinute(hour, min));
         } else  if (event.getFrequency().equalsIgnoreCase("weekly")) {
            tb.withSchedule(weeklyOnDayAndHourAndMinute(DateBuilder.MONDAY, hour, min));
         }

//         if (event.isIgnoreWeekends()) {
//            tb.modifiedByCalendar("weeklyCalendar");
//         }

         if (event.getCalendars()!=null) {
            for (String cal : event.getCalendars()) {
               tb.modifiedByCalendar(cal);
            }
         }

         Trigger trigger = tb.build();

         if(scheduler.getJobDetail(job.getKey())==null) {
            scheduler.scheduleJob(job, trigger);
         } else {
            scheduler.addJob(job, true);
            scheduler.rescheduleJob(trigger.getKey(), trigger);

         }
      } catch (ClassNotFoundException e) {
         e.printStackTrace();

      } catch (SchedulerException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }

   }

   /**
    * Creates a registration mail that will be sent now
    *
    * @param userId
    * @param context
    */
   public void createRegistrationJob(String userId, String context) {
      JobDetail job = newJob(QuartzJob.class).usingJobData("userId", userId).withIdentity("registration." + userId,  context).build();
      try {
         Trigger trigger = newTrigger().withIdentity("registration." + userId ,"cronobiz").startNow().build();
         scheduler.scheduleJob(job, trigger);
      } catch (SchedulerException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
   }

}
