package Day2.lab2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;

public class UDPFileSender {

    public static void main(String[] args) {
        DatagramSocket dgSocket = null;

        try {
            dgSocket = new DatagramSocket();
            byte[] bytes = new byte[1000];
            InetAddress serverHost = InetAddress.getByName("localhost");
            int serverPortNumber = 3000;
            BufferedReader fileReader = new BufferedReader(new FileReader("src/main/resources/text.txt"));

            String line = fileReader.readLine();
            while (line != null) {
                bytes = line.getBytes(StandardCharsets.UTF_8);
                dgSocket.send(new DatagramPacket(bytes,
                        bytes.length, serverHost, serverPortNumber));
                line = fileReader.readLine();
                Thread.sleep(1000);
            }


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            if (dgSocket != null) {
                dgSocket.close();
            }

        }
    }
}
