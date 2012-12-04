package quartz;

import com.google.inject.Inject;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.jms.*;

/**
 * Date: 2012/06/19
 * <p/>
 * The source, with you may it be old master.
 */
public class SendMailJob implements Job {



   private ConnectionFactory cf;
   private Connection connection;
   private Session session;
   private MessageProducer producer;

   private String someDetail;

   public SendMailJob() {
      
      cf = new ActiveMQConnectionFactory("tcp://localhost:61616");
      try {
         connection = cf.createConnection();
         session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
         Destination dest = session.createTopic("CBIZ.EVENTS");
         producer = session.createProducer(dest);

      } catch (JMSException e) {
         throw new RuntimeException(e);
      }
   }

   public void execute(JobExecutionContext context) throws JobExecutionException {
      System.out.println("send email request to queue " + getSomeDetail());
      try {
         TextMessage msg = session.createTextMessage(getSomeDetail());
         msg.setStringProperty("Event.Class", "com.guruhut.cronobiz.events.RegistrationCompleteEvent");
         producer.send(msg);
      } catch (JMSException e) {
         e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
      }
   }

   public String getSomeDetail() {
      return someDetail;
   }

   public void setSomeDetail(String someDetail) {
      this.someDetail = someDetail;
   }
}
