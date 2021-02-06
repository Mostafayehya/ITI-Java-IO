package Day2.lecturesamples.sample4;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class URLConnectionTest {

    public static void main(String[] args) {
        try {

            String urlName = "http://www.iti.gov.eg";
            URL url = new URL(urlName);

            URLConnection urlConnection = url.openConnection();
            urlConnection.connect();

            Map<String, List<String>> headers = urlConnection.getHeaderFields();

            for (Map.Entry<String, List<String>> entry : headers.entrySet()) {

                String key = entry.getKey();
                for (String value : entry.getValue()) {
                    System.out.println(key + ": " + value);
                }
            }
            System.out.println("------------------------");
            System.out.println("getContentType: " + urlConnection.getContentType());
            System.out.println("getContentLength: " + urlConnection.getContentLength());
            System.out.println("getContentEncoding: " + urlConnection.getContentEncoding());
            System.out.println("getDate: " + urlConnection.getDate());
            System.out.println("getExpiration: " + urlConnection.getExpiration());
            System.out.println("getLastModified: " + urlConnection.getLastModified());
            String encoding = urlConnection.getContentEncoding();
            if (encoding == null) encoding = "UTF-8";

            try (Scanner in = new Scanner(urlConnection.getInputStream(), encoding)) {

                for (int n = 1; in.hasNextLine() && n <= 10; n++) {
                    System.out.println(in.nextLine());
                    if (in.hasNextLine()) {
                        System.out.println(". . .");
                    }
                }
            }


        } catch (MalformedURLException malformedURLException) {
            malformedURLException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
