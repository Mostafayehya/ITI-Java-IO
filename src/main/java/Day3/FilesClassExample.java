package Day3;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesClassExample {

    public static void main(String[] args) throws URISyntaxException {

        Path path3 = Paths.get("src/main/resources/data");
         try{
             Path newDir = Files.createDirectory(path3);

         } catch (IOException e) {
             e.printStackTrace();
         }

         Path sourcePath = Paths.get("serial.txt");
         Path destinationPath =
                 Paths.get("src/main/resources/data/serial-copy.txt");

         try{
             Files.copy(sourcePath, destinationPath);
         }catch (FileAlreadyExistsException e){
             e.printStackTrace();
         } catch (IOException e) {
             e.printStackTrace();
         }

    }
}
