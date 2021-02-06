package Day2.lab2;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPFileReceiver {

    public static void main(String[] args) {
        DatagramSocket dgSocket = null;
        try {
            dgSocket = new DatagramSocket(3000);
            while (true) {
                DatagramPacket dgResponse = new DatagramPacket(new byte[1000], 1000);
                dgSocket.receive(dgResponse);
                System.out.println(new String(dgResponse.getData()));

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
