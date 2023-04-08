package files.task4;

import java.io.Serializable;

public class Cat implements Serializable {
    String name;
    String colour;
    double weight;

    public Cat(String name, String colour, double weight) {
        this.name = name;
        this.colour = colour;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", colour='" + colour + '\'' +
                ", weight=" + weight +
                '}';
    }
}
