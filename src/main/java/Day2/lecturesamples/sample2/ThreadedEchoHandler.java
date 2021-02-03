package Day2.lecturesamples.sample2;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ThreadedEchoHandler implements Runnable {

    private Socket incomingSocket;

    public ThreadedEchoHandler(Socket incoming) {
        this.incomingSocket = incoming;
    }

    @Override
    public void run() {

        try (InputStream inputStream = incomingSocket.getInputStream();
             OutputStream outputStream = incomingSocket.getOutputStream()) {

            Scanner in = new Scanner(inputStream, StandardCharsets.UTF_8);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);
            out.println("Hello !, Enter \"Bye\" to Exit");
            boolean done = false;

            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                out.println("Echo: " + line);
                if (line.trim().equals("Bye")) {
                    done = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
