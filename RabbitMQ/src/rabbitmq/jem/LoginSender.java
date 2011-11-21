package rabbitmq.jem;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * The source, with you may it be old master
 * Date: 2011/11/14
 */
public class LoginSender {

    public static void main(String[] args) {
        ConnectionFactory cf = new ConnectionFactory();
        cf.setHost("192.168.0.78");
        Connection conn = null;
        try {
            conn = cf.newConnection();

            Channel channel = conn.createChannel();
            channel.exchangeDeclare("JEM", "topic", true);

            String routingKey = "login.donovan";
            String message = "{\"username\" : \"donovan\", \"password\" : \"helmet\"}";

            channel.basicPublish("JEM", routingKey, null, message.getBytes());


        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            try {
                conn.close();
            } catch (IOException e) {
                e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
            }
        }
    }
}
