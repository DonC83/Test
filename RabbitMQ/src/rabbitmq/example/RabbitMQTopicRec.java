package rabbitmq.example;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.QueueingConsumer;

/**
 * The source, with you may it be old master
 * Date: 2011/11/09
 */
public class RabbitMQTopicRec {

    private static final String EXCHANGE_NAME = "jem";

    public static void main(String[] args)
                  throws Exception {

        String [] argv = new String[] {"#"};

        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.0.233");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.exchangeDeclare(EXCHANGE_NAME, "topic");
//        String queueName = channel.queueDeclare().getQueue();
        channel.queueDeclare("jem", true, false, false, null);



        if (argv.length < 1){
            System.err.println("Usage: ReceiveLogsTopic [binding_key]...");
            System.exit(1);
        }

        for(String bindingKey : argv){
            channel.queueBind("jem", EXCHANGE_NAME, bindingKey);
        }

        System.out.println(" [*] Waiting for messages. To exit press CTRL+C");

        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume("jem", true, consumer);

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            String routingKey = delivery.getEnvelope().getRoutingKey();

            System.out.println(" [x] Received '" + routingKey + "':'" + message + "'");
        }
    }

}
