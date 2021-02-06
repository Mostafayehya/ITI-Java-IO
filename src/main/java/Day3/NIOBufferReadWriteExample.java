package Day3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIOBufferReadWriteExample {

    public static void main(String[] args) {
        Path path = Paths.get("test.txt");

        write(path);
        read(path);
    }

    private static void write(Path path) {

        String input = "NIO Buffer Hello World!";

        byte[] inputBytes = input.getBytes(StandardCharsets.UTF_8);
        ByteBuffer byteBuffer = ByteBuffer.wrap(inputBytes);

        FileChannel channelWrite = null;
        try {
            channelWrite = FileChannel.open(path, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            channelWrite.write(byteBuffer);
            channelWrite.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private static void read(Path path) {

        try {
            FileChannel channelRead = FileChannel.open(path);
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);

            channelRead.read(byteBuffer);
            byte[] byteArray = byteBuffer.array();
            String fileContent = new String(byteArray).trim();
            System.out.println("File content:" + fileContent);

            channelRead.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
