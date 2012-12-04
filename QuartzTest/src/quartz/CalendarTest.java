package quartz;

import org.quartz.impl.calendar.CronCalendar;
import org.quartz.impl.calendar.HolidayCalendar;
import org.quartz.impl.calendar.WeeklyCalendar;

import java.text.ParseException;
import java.util.Date;
import java.util.SortedSet;

/**
 * Date: 2012/06/26
 * <p/>
 * The source, with you may it be old master.
 */
public class CalendarTest {

   public static void main(String[] args) {
      WeeklyCalendar wc = new WeeklyCalendar();
      boolean [] bool = wc.getDaysExcluded();
      for (boolean b : bool) {
         System.out.println(b);
      }
      HolidayCalendar hc = new HolidayCalendar(wc);

      SortedSet<Date> ss = hc.getExcludedDates();

      for (Date d : ss) {
         System.out.println(d);
      }
      

   }
}
