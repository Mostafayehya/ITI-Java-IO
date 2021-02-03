package Day2.lecturesamples;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class SimpleSocketClient {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 1286);

        InputStream socketInputStream = socket.getInputStream();

        DataInputStream socketDataInputStream = new DataInputStream(socketInputStream);

        String comingString= socketDataInputStream.readUTF();

        System.out.println(comingString);

        socketDataInputStream.close();
        socketInputStream.close();
        socket.close();

    }
}
