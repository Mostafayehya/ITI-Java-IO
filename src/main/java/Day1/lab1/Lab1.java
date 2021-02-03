package Day1.lab1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Lab1 {

    public static void main(String[] args) {

        String[] arr = new String[1000];
        int iterator = 0;
        String input;

        BufferedReader br = null;

        try {
            br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("Insert lines, or 'stop' to quit");

            do {
                input = br.readLine();
                if (!input.equals("stop")) {
                    arr[iterator] = input;
                    iterator++;
                }
                if (iterator == 100)
                    break;

            } while (!input.equals("stop"));

            br.close();

            iterator = 0;

            while (arr[iterator] != null) {
                System.out.println(arr[iterator]);
                iterator++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
