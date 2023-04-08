package files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Task3 {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("task2.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);
        String result = "";
        while (bufferedReader.ready()){
            result+=bufferedReader.readLine()+" ";
        }
        System.out.println(result);
        reader.close();
    }
}
