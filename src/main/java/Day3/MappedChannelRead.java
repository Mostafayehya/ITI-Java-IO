package Day3;

import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MappedChannelRead {

    public static void main(String[] args) {
        try(FileChannel fileChannel = (FileChannel) Files.newByteChannel(
                Paths.get("src/main/resources/data/reading.txt"
                ))) {

            long fileSize = fileChannel.size();

            MappedByteBuffer mappedBuffer = fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, fileSize);
            for (int i = 0; i <fileSize ; i++) { // todo ) looping only once
                System.out.println((char) mappedBuffer.get());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
