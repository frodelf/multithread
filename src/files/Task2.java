package files;

import java.io.*;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) throws IOException {
        FileWriter file = new FileWriter("task2.txt");

        Scanner scanner = new Scanner(System.in);
        String names = scanner.nextLine();
        //names = normalText(names);
        file.write(names);

        file.close();
    }

    static String normalText(String string){
        char[] arr = string.toCharArray();
        String result = "";
        for (char c : arr) {
            if(c == ' '){
                c = '\n';
            }
            result+=c;
        }
        return result;
    }
}
