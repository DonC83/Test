package quartz;

import com.google.inject.Inject;
import org.quartz.*;


/**
 * Date: 2012/06/22
 * <p/>
 * The source, with you may it be old master.
 */
public class QuartzScheduleListener implements SchedulerListener {

   private Scheduler scheduler;

   public QuartzScheduleListener(Scheduler scheduler) {
      this.scheduler = scheduler;
   }

   public void jobScheduled(Trigger trigger) {
      System.out.println("job with triggerkey " + trigger.getKey() + " scheduled.");
   }

   public void jobUnscheduled(TriggerKey triggerKey) {
      System.out.println("job with triggerkey " + triggerKey.getName() + " unscheduled.");
   }

   public void triggerFinalized(Trigger trigger) {
      System.out.println("Trigger triggerkey " + trigger.getKey() + " finalized.");
   }

   public void triggerPaused(TriggerKey triggerKey) {
      //To change body of implemented methods use File | Settings | File Templates.
   }

   public void triggersPaused(String s) {
      //To change body of implemented methods use File | Settings | File Templates.
   }

   public void triggerResumed(TriggerKey triggerKey) {
      //To change body of implemented methods use File | Settings | File Templates.
   }

   public void triggersResumed(String s) {
      //To change body of implemented methods use File | Settings | File Templates.
   }

   public void jobAdded(JobDetail jobDetail) {
      System.out.println("job with key " + jobDetail.getKey() + " added.");
   }

   public void jobDeleted(JobKey jobKey) {
      System.out.println("job with key " + jobKey + " deleted.");
   }

   public void jobPaused(JobKey jobKey) {
      //To change body of implemented methods use File | Settings | File Templates.
   }

   public void jobsPaused(String s) {
      //To change body of implemented methods use File | Settings | File Templates.
   }

   public void jobResumed(JobKey jobKey) {
      //To change body of implemented methods use File | Settings | File Templates.
   }

   public void jobsResumed(String s) {
      //To change body of implemented methods use File | Settings | File Templates.
   }

   public void schedulerError(String s, SchedulerException e) {
      //To change body of implemented methods use File | Settings | File Templates.
   }

   public void schedulerInStandbyMode() {
      //To change body of implemented methods use File | Settings | File Templates.
   }

   public void schedulerStarted() {
      //To change body of implemented methods use File | Settings | File Templates.
   }

   public void schedulerShutdown() {
      //To change body of implemented methods use File | Settings | File Templates.
   }

   public void schedulerShuttingdown() {
      //To change body of implemented methods use File | Settings | File Templates.
   }

   public void schedulingDataCleared() {
      //To change body of implemented methods use File | Settings | File Templates.
   }
}
