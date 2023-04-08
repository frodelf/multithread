package files.task4;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeCats {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("cats.txt");
        ObjectInputStream oin = new ObjectInputStream(fis);
        System.out.println(((Person) oin.readObject()).getCats());
    }
}
