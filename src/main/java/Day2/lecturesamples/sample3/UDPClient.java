package Day2.lecturesamples.sample3;

import java.io.File;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;

public class UDPClient {


    public static void main(String[] args) {
        DatagramSocket dgSocket = null;

        try {
            dgSocket = new DatagramSocket();
            byte[] bytes = "mostafa yehya".getBytes();
            InetAddress serverHost = InetAddress.getByName("localhost");
            int serverPortNumber = Integer.valueOf(3000);
            DatagramPacket dgRequest = new DatagramPacket(bytes,
                    "mostafa yehya".length(), serverHost, serverPortNumber);
            dgSocket.send(dgRequest);

            byte[] byteBuffer = new byte[1000];
            DatagramPacket dgRespone = new DatagramPacket(byteBuffer,
                    byteBuffer.length);
            dgSocket.receive(dgRespone);
            System.out.println("Datagram Response: " + new String(dgRespone.getData()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException unknownHostException) {
            unknownHostException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (dgSocket !=null){
                dgSocket.close();
            }

        }
    }


}
