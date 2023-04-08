package task2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class Runner {
    public static ArrayList<User> users = new ArrayList<>();
    public static int value;
    public static void main(String[] args) throws Exception {

        users.add(new User("Artem"));
        users.add(new User("Denis"));
        users.add(new User("Vika"));
        users.add(new User("Lina"));
        users.add(new User("Sasha"));

        new UsuallyThread().showList(users);
        Scanner scanner = new Scanner(System.in);
        value = scanner.nextInt();
        DaemonThread thread = new DaemonThread();
        thread.setDaemon(true);
        thread.start();
        Callable<User> user = new UsuallyThread();
        FutureTask futureTask = new FutureTask(user);
        new Thread(futureTask).start();
        System.out.println("\n"+futureTask.get());
    }
}
