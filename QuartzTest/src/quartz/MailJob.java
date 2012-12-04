package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Date: 2012/06/18
 * <p/>
 * The source, with you may it be old master.
 */
public class MailJob extends QuartzJob   {

   public MailJob() {

   }

   public void execute(JobExecutionContext context) throws JobExecutionException {
      System.out.println("send mail job to " + getUserId());
   }

}
