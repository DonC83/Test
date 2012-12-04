package quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Date: 2012/06/22
 * <p/>
 * The source, with you may it be old master.
 */
public class QuartzJob implements Job {

   private String userId;

   public void execute(JobExecutionContext context) throws JobExecutionException {
      System.out.println("send something with userId=" + userId);
   }

   public String getUserId() {
      return userId;
   }

   public void setUserId(String userId) {
      this.userId = userId;
   }
}
