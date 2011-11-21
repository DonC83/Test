package rabbitmq.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * The source, with you may it be old master
 * Date: 2011/11/09
 */
public class RabbitMQTopicSend {

    private static final String EXCHANGE_NAME = "jem";

    public static void main(String[] argv)
            throws Exception {

        argv = new String[] {"{\"username\" : \"donovan\" , \"status\":\"Logged In\"}"};

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.0.2");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");

        String routingKey = getRouting(argv);
        String message = getMessage(argv);



        channel.basicPublish(EXCHANGE_NAME, "status", null, message.getBytes());
        System.out.println(" [x] Sent '" + "status" + "':'" + message + "'");

        connection.close();
    }

    private static String getMessage(String[] strings){
        if (strings.length < 1)
            return "info: Hello World!";
        return joinStrings(strings, " ");
    }

    private static String joinStrings(String[] strings, String delimiter) {
        int length = strings.length;
        if (length == 0) return "";
        StringBuilder words = new StringBuilder(strings[0]);
        for (int i = 1; i < length; i++) {
            words.append(delimiter).append(strings[i]);
        }
        return words.toString();
    }

    private static String getRouting(String[] strings){
    if (strings.length < 1)
    	    return "anonymous.info";
    return strings[0];
  }

}
