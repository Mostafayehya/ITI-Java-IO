package Day2.lecturesamples.sample1;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleSocketServer {


    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1286);

        Socket socket = serverSocket.accept(); // blocking operation

        OutputStream socketOutputStream =socket.getOutputStream();
        DataOutputStream socketDataOutputStream = new DataOutputStream(socketOutputStream);

        socketDataOutputStream.writeUTF("Hello world");

        // what is the difference between  DataOutputstream and output stream out of socket
        socketDataOutputStream.close();
        socketOutputStream.close();
        serverSocket.close();



    }
}
