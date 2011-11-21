package rabbitmq.jem;

import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.QueueingConsumer;
import com.rabbitmq.client.AMQP.BasicProperties;

import java.io.IOException;
import java.util.UUID;

/**
 * The source, with you may it be old master
 * Date: 2011/11/14
 */
public class LoginRPCSend {

    Connection connection;
    Channel channel;
    QueueingConsumer consumer;
    String replyQueueName;

    public LoginRPCSend() throws IOException {
        ConnectionFactory cf = new ConnectionFactory();

        cf.setHost("192.168.0.78");

        connection = cf.newConnection();
        channel = connection.createChannel();

        replyQueueName = channel.queueDeclare().getQueue();
        consumer = new QueueingConsumer(channel);

        channel.basicConsume(replyQueueName, true, consumer);
    }


    public String call(String message) throws IOException, InterruptedException {
        String response = null;
        String corrId = UUID.randomUUID().toString();

        BasicProperties props = new BasicProperties
                .Builder()
                .correlationId(corrId)
                .replyTo(replyQueueName)
                .build();

        channel.basicPublish("", "loginrpc_queue", props, message.getBytes());

        while (true) {
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            System.out.println(delivery);
            if (delivery.getProperties().getCorrelationId().equals(corrId)) {
                response = new String(delivery.getBody(),"UTF-8");
                break;
            }
        }

        return response;
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        LoginRPCSend rpcSend = new LoginRPCSend();
        System.out.println(rpcSend.call("login donovan"));


        System.out.println("1");

    }

}
