package quartz;

import com.google.inject.AbstractModule;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Date: 2012/06/19
 * <p/>
 * The source, with you may it be old master.
 */
public class QuartzModule extends AbstractModule {

   @Override
   protected void configure() {
      try {
         bind(Scheduler.class).toInstance(StdSchedulerFactory.getDefaultScheduler());
         bind(QuartzSchedule.class).asEagerSingleton();

      } catch (SchedulerException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
   }
}
