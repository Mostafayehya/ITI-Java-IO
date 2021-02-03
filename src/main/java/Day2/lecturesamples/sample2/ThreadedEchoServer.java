package Day2.lecturesamples.sample2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedEchoServer {

    static long startTime;
    static long endTime;

    public static void main(String[] args) {
        try {
            ServerSocket ss = new ServerSocket(8189, 1);
            int i = 1;

            while (true) {
                startTime = System.currentTimeMillis();
                Socket incoming = ss.accept();
                endTime = System.currentTimeMillis();

                System.out.println("Waiting time : " + (endTime-startTime) );
                System.out.println("Spawning " + i);

                Runnable r = new ThreadedEchoHandler(incoming);
                Thread t = new Thread(r);

                t.start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
