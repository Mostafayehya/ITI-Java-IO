package Day3.asyncserver;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousSocketChannel;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) {
        try(AsynchronousSocketChannel client =
                AsynchronousSocketChannel.open()){

            Future<Void> result = client.connect(new InetSocketAddress("127.0.0.1", 1234));
            result.get();

            String message = "What's up Server *virtual bro fist*";

            ByteBuffer buffer = ByteBuffer.wrap(message.getBytes());
            Future<Integer> writeVal = client.write(buffer);
            System.out.println("sending to server the following: " + message);
            writeVal.get();

            buffer.flip();
            Future<Integer> readVal = client.read(buffer);
            readVal.get();
            System.out.println("Received from server: " + new String(buffer.array()).trim());
            buffer.clear();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("Disconnected from server");
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
