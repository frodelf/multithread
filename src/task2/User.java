package task2;

public class User {
    int id;
    static int getId = 0;
    String name;

    public User(String name) {
        this.id = ++getId;
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
