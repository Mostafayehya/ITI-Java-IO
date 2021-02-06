package Day3;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class WritingFileViaChannel {

    public static void main(String[] args) {
        try (FileChannel fileChannel = (FileChannel)
                Files.newByteChannel(
                        Paths.get("src/main/resources/data/writing.txt"),
                     StandardOpenOption.WRITE,StandardOpenOption.CREATE) ){

            ByteBuffer byteBuffer = ByteBuffer.allocate(26);

            for (int i=0;i<26;i++){
                byteBuffer.put((byte)('a' + i));
            }
            byteBuffer.rewind(); // why not flip() Answer-> because flip() is used between operations for relative read and write preparation


            fileChannel.write(byteBuffer);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
