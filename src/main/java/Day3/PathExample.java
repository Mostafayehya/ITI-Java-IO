package Day3;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {

    public static void main(String[] args) {
        String originalPath = "E:\\ITI 2020\\IO\\Java IO\\test.txt";
        Path path1 = Paths.get(originalPath);

        Path path = Paths.get("E:\\ITI 2020\\IO\\Java IO\\serial.txt");
        System.out.println("path =" + path);
        System.out.println("path1 =" + path1);

        Path path2 = path1;
        System.out.println("path2 =" + path2);
    }
}
