package rabbitmq.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;

/**
 * The source, with you may it be old master
 * Date: 2011/11/08
 */
public class RabbitMQWQSend {

    private final static String QUEUE_NAME = "task_queue";

    public static void main(String[] args) throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.0.233");
        Connection conn = factory.newConnection();
        Channel channel = conn.createChannel();

        boolean durable = true;
        channel.queueDeclare(QUEUE_NAME, durable, false, false, null);

        String message = getMessage(new String[]{"This is sparta!!!", "or not"});

        channel.basicPublish("", QUEUE_NAME, MessageProperties.PERSISTENT_TEXT_PLAIN, message.getBytes());
        System.out.println("[x] Sent '" + message + "'");

        channel.close();
        conn.close();
    }

    private static String getMessage(String [] strings) {
        if (strings.length<1) {
            return "Hello World";
        }
        return joinStrings(strings, "");
    }

    private static String joinStrings(String [] strings, String delimiter) {
        int length = strings.length;
        if (length == 0) return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }

}
