import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CaesarCipher {

    public static void main(String[] args) {
        try {
            CaesarCipher.decryptFile("output.txt", "decrypted.txt", 3);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }


    public static void encryptFile(String inputFilePath, String outputFilePath, int shift) throws FileNotFoundException, FileNotFoundException {
        // Відкриємо файл для зчитування
        File inputFile = new File(inputFilePath);

        Scanner in = new Scanner(inputFile);

        // Відкриємо файл для запису
        File outputFile = new File(outputFilePath);



        PrintWriter out = new PrintWriter(outputFile);

        // Прочитаємо і зашифруємо кожен рядок
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String encryptedLine = encrypt(line, shift);
            out.println(encryptedLine);
        }

        in.close();
        out.close();
    }

    public static void decryptFile(String inputFilePath, String outputFilePath, int shift) throws FileNotFoundException {
        // Відкриємо файл для зчитування
        File inputFile = new File(inputFilePath);
        Scanner in = new Scanner(inputFile);

        // Відкриємо файл для запису
        File outputFile = new File(outputFilePath);
        PrintWriter out = new PrintWriter(outputFile);

        // Прочитаємо і розшифруємо кожен рядок
        while (in.hasNextLine()) {
            String line = in.nextLine();
            String decryptedLine = decrypt(line, shift);
            out.println(decryptedLine);
        }

        in.close();
        out.close();
    }

    public static String encrypt(String input, int shift) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }
            output.append(c);
        }
        return output.toString();
    }

    public static String decrypt(String input, int shift) {
        return encrypt(input, 26 - shift);
    }
}