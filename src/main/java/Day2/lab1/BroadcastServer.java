package Day2.lab1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class BroadcastServer {


    public static void main(String[] args) {
        List<Socket> currentClientSockets = new ArrayList<>();
        try {
            ServerSocket ss = new ServerSocket(8189);
            int i = 1;

            while (true) {
                Socket incoming = ss.accept();

                currentClientSockets.add(incoming);
                System.out.println("Clients' #" + i);
                Runnable r = new BroadcastHandler(incoming,currentClientSockets);
                Thread t = new Thread(r);

                t.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
