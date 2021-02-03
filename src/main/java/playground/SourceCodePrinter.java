package playground;

import java.io.*;

public class SourceCodePrinter {

    public static void main(String[] args) throws IOException {
        File file = new File("src/main/java/playground/SourceCodePrinter.java");
        FileInputStream fileInputStream = new FileInputStream(file);


        int c;
         while ((c=fileInputStream.read()) != -1){
             System.out.print((char) c);
         }

    }
}
