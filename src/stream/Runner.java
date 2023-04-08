package stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>();
        users.add(new User("Ivan", 17));
        users.add(new User("Denis", 47));
        users.add(new User("Artem", 18));
        users.add(new User("Bogdan", 57));

        List<String> task1 = users.stream().sorted((x,y)->
            x.getName().compareTo(y.getName())
        ).filter(el->el.getAge()<40).map(el->el.getName()).limit(3).toList();
        showListStr(task1);
    }

    static void showList(List<User> users){
        System.out.println("\n\n");
        users.stream().forEach(System.out::println);
    }

    static void showListStr(List<String> users){
        System.out.println("\n\n");
        users.stream().forEach(System.out::println);
    }
}
