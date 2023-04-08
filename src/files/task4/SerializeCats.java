package files.task4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializeCats  {
    public static void main(String[] args) throws IOException {
        Person person = new Person();

        person.getCats().add(new Cat("AAA", "BBB", 5));
        person.getCats().add(new Cat("A","dkng", 783));
        person.getCats().add(new Cat("A","dkng", 783));
        person.getCats().add(new Cat("A","dkng", 783));

        System.out.println(person.getCats());

        FileOutputStream fos = new FileOutputStream("cats.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);

        oos.writeObject(person);

        oos.close();
    }
}
