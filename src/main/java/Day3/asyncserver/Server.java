package Day3.asyncserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousServerSocketChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Server {

    public static void main(String[] args) {
        try (AsynchronousServerSocketChannel serverSocket =
                     AsynchronousServerSocketChannel.open()) {

            serverSocket.bind(new InetSocketAddress("127.0.0.1", 1234));
            Future<AsynchronousSocketChannel> acceptedSocketChannel = serverSocket.accept();

            AsynchronousSocketChannel clientSocketChannel = acceptedSocketChannel.get(10, TimeUnit.SECONDS);

            if (clientSocketChannel != null && clientSocketChannel.isOpen()) {
                ByteBuffer buffer = ByteBuffer.allocate(1024);

                Future<Integer> dataReceived = clientSocketChannel.read(buffer);
                dataReceived.get();
                System.out.println("Client sent: " + new String(buffer.array()).trim());
                buffer.flip();
                String message = "Doing fine bro *bro fists* ";
                Future<Integer> toSend = clientSocketChannel.write(ByteBuffer.wrap(message.getBytes()));
                System.out.println("Sending data to client :" + message);
                toSend.get();
                buffer.clear();

                clientSocketChannel.close();

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }


    }
}
