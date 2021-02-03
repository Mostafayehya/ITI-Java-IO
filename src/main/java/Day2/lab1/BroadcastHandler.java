package Day2.lab1;

import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BroadcastHandler implements Runnable {

    private Socket incomingSocket;
    List<Socket> currentClientSockets ;


    public BroadcastHandler(Socket incoming,List<Socket> currentClientSockets) {
        this.incomingSocket = incoming;
        this.currentClientSockets = currentClientSockets;
    }

    @Override
    public void run() {

        try (InputStream inputStream = incomingSocket.getInputStream();
             OutputStream outputStream = incomingSocket.getOutputStream()) {

            Scanner in = new Scanner(inputStream, StandardCharsets.UTF_8);
            PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);
            boolean done = false;
            out.println("Hello !, Enter \"Bye\" to Exit");

            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                sendToAllConnectedClients(line);
                if (line.trim().equals("Bye")) {
                    done = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void sendToAllConnectedClients(String line) {

        for (int i = 0; i <currentClientSockets.size() ; i++) {
            try (OutputStream outputStream = currentClientSockets.get(i).getOutputStream()) {

                PrintWriter out = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);
                out.println(line);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        }
    }

