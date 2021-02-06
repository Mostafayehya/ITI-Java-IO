package Day2.lecturesamples.sample3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {

    public static void main(String[] args) {
        DatagramSocket dgSocket = null;
        try {
             dgSocket = new DatagramSocket(3000);
            byte[] byteBuffer = new byte[1000];
            while (true) {
                DatagramPacket dgResponse = new DatagramPacket(byteBuffer, byteBuffer.length);
                dgSocket.receive(dgResponse);

                DatagramPacket dgRequest = new DatagramPacket(dgResponse.getData(),
                        dgResponse.getLength(),
                        dgResponse.getAddress(), dgResponse.getPort());
                dgSocket.send(dgRequest);
                
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (dgSocket != null) {
                dgSocket.close();
            }
        }
    }

}
