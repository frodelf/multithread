package files.task4;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Person implements Serializable {
    private  ArrayList<Cat> cats;

    Person(){
        cats = new ArrayList<>();
    }

    public void setCats(ArrayList<Cat> cats) {
        this.cats = cats;
    }

    public ArrayList<Cat> getCats() {
        return cats;
    }
}
