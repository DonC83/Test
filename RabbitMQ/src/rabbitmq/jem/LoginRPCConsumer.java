package rabbitmq.jem;


import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.AMQP.BasicProperties;

import java.io.IOException;

/**
 * The source, with you may it be old master
 * Date: 2011/11/14
 */
public class LoginRPCConsumer {

    public static void main(String[] args) throws IOException, InterruptedException {
        ConnectionFactory cf = new ConnectionFactory();
        cf.setHost("192.168.0.78");

        Connection connection = cf.newConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("loginrpc_queue", false, false, false, null);

        channel.basicQos(1);


        QueueingConsumer consumer = new QueueingConsumer(channel);
        channel.basicConsume("loginrpc_queue", false, consumer);

        while(true) {

            QueueingConsumer.Delivery delivery = consumer.nextDelivery();

            BasicProperties props = delivery.getProperties();
            BasicProperties replyProps = new BasicProperties.Builder().correlationId(props.getCorrelationId()).build();

            String message = new String(delivery.getBody());

            System.out.println("received " + message);

            System.out.println("must replyto " + props.getReplyTo());

            Thread.sleep(30000);
            channel.basicPublish("", props.getReplyTo(), replyProps, "response leg".getBytes());
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);

        }



    }
}
