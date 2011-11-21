package rabbitmq.jem;

import com.rabbitmq.client.*;

import java.io.IOException;

/**
 * The source, with you may it be old master
 * Date: 2011/11/14
 */
public class LoginConsumerProducer {

    public static void main(String[] args) {
        ConnectionFactory cf = new ConnectionFactory();
        cf.setHost("192.168.0.78");

        Connection conn = null;
        try {
            conn = cf.newConnection();
            Channel channel = conn.createChannel();
            channel.exchangeDeclare("JEM", "topic", true);
            String queue = channel.queueDeclare().getQueue();

            channel.queueBind(queue, "JEM", "login.#");

            QueueingConsumer consumer = new QueueingConsumer(channel);
            channel.basicConsume(queue, true, consumer);



            while (true) {
                QueueingConsumer.Delivery delivery = consumer.nextDelivery();
                String message  = new String(delivery.getBody());
                String routingKey = delivery.getEnvelope().getRoutingKey();
                System.out.println(" [x] Received '" + routingKey + "':'" + message + "'");

                String respRK = routingKey + ".resp";




            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
