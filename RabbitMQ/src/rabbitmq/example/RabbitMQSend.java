package rabbitmq.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

/**
 * The source, with you may it be old master
 * Date: 2011/11/07
 */
public class RabbitMQSend {

    private final static String QUEUE_NAME = "jem";

    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.0.233");
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();

        channel.queueDeclare(QUEUE_NAME, false, false, false, null);

        String message = "{\"username\" : \"donovan\", \"status\" : \"logged out\"}";

        channel.basicPublish("", QUEUE_NAME, null, message.getBytes());
        System.out.println("[x] Sent '" + message + "'");

        channel.close();
        conn.close();
    }
}
