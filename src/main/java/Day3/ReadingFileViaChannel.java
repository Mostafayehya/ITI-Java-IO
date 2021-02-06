package Day3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReadingFileViaChannel {

    public static void main(String[] args) {
        int count;
        Path filepath = null;

        try {
            filepath = Paths.get("src/main/resources/data/reading.txt");
        } catch (InvalidPathException e) {
            System.out.println("Path Error:" + e);
            return;
        }

        try (SeekableByteChannel fileChannel = Files.newByteChannel(filepath)) {

            ByteBuffer mByteBuffer = ByteBuffer.allocate(128);

            do { //todo) notice how I loop twice to be able to iterate
                count = fileChannel.read(mByteBuffer);
                if (count != -1) {
                    mByteBuffer.rewind();
                    for (int i = 0; i < count; i++) {
                        System.out.println((char) mByteBuffer.get());
                    }
                }

            } while (count != -1);
            System.out.println();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
