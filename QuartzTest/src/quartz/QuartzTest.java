package quartz;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.jobs.ee.jms.SendDestinationMessageJob;

import javax.inject.Inject;
import javax.jms.ConnectionFactory;
import java.util.Date;

import static org.quartz.JobBuilder.*;
import static org.quartz.TriggerBuilder.*;
import static org.quartz.DateBuilder.*;
import static org.quartz.SimpleScheduleBuilder.*;

/**
 * Date: 2012/06/18
 * <p/>
 * The source, with you may it be old master.
 */
public class QuartzTest {

   public static void main(String[] args) {
      QuartzTest qt = new QuartzTest();

      qt.scheduleJob("job1", "{'userId':'1000', 'remove':'true'}", new Date(), 60000, "1");
      
   }

   private Scheduler scheduler;
   private ConnectionFactory cf;

   public QuartzTest() {
      Injector injector = Guice.createInjector(new QuartzModule());
      cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
      // Grab the Scheduler instance from the Factory
      try {
         scheduler = injector.getInstance(Scheduler.class);
         scheduler.start();
      } catch (SchedulerException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
   }

   private void scheduleJob(String jobName, String someDetail, Date startTime, long interval, String userId) {
      JobDetail job = newJob(SendMailJob.class).withIdentity(jobName)
              .usingJobData("someDetail", someDetail).build();

//      JobDetail job = newJob(SendDestinationMessageJob.class).withIdentity(jobName)
//              .usingJobData("JMS_CONNECTION_FACTORY_JNDI", "org.apache.activemq.jndi.ActiveMQInitialContextFactory")
//              .usingJobData("org.apache.activemq.jndi.ActiveMQInitialContextFactory","").build();

      Date endtime = evenMinuteDate(new Date(System.currentTimeMillis() + 60000));
//      Trigger trigger = newTrigger().withIdentity("sendMailTrigger-" + jobName)
//              .startAt(runtime).withSchedule(simpleSchedule().withIntervalInMilliseconds(10000).repeatForever())
//              .endAt(endtime).build();

      Trigger trigger = newTrigger().withIdentity("sendMailTrigger-" + jobName)
              .startNow()
              .build();


      try {
         scheduler.scheduleJob(job, trigger);
         Thread.sleep(10000);
         scheduler.shutdown();
      } catch (SchedulerException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      } catch (InterruptedException e) {
         e.printStackTrace();
      }

   }

}
