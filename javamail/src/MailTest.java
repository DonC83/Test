
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

/**
 * The source, with you may it be old master
 * Date: 2012/02/01
 */
public class MailTest {


    public static void main(String[] args) {
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");
        Session session = Session.getDefaultInstance(props,
			new javax.mail.Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("support@chase.za.net","chaseadmin");
				}
			});

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("support@chase.za.net"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("handri@guruhut.com"));
            message.setText("Testing send mail");
            message.setSentDate(new Date());
            message.setSubject("Testing from Donovan");

            Transport.send(message);
        } catch (NoSuchProviderException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } catch (MessagingException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
    }
}
