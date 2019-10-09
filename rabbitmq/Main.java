import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.DeliverCallback;


class ReceiveThread extends Thread {
    public void run() {
        try {
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare("窝窝头", false, false, false, null);

            DeliverCallback deliverCallback = (consumerTag, delivery) -> {
                String recvMessage = new String(delivery.getBody(), "UTF-8");
                System.out.println(" [x] Received '" + recvMessage + "'");
            };
            channel.basicConsume("窝窝头", true, deliverCallback, consumerTag -> {
            });
        } catch (Exception e) {

        }
    }
}

class SendThread extends Thread {
    public void run() {
        try {
            Thread.sleep(1000);
            ConnectionFactory factory = new ConnectionFactory();
            factory.setHost("localhost");
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();

            channel.queueDeclare("窝窝头", false, false, false, null);
            String message = "麻麻我想吃烤山摇";
            channel.basicPublish("", "窝窝头", null, message.getBytes());
            System.out.println(" [x] Sent '" + message + "'");

        } catch (Exception e) {

        }
    }
}

public class Main {

    public static void main(String[] argv) throws Exception {
        ReceiveThread receiveThread = new ReceiveThread();
        receiveThread.start();
        SendThread sendThread = new SendThread();
        sendThread.start();
    }

}