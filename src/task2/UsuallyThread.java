package task2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class UsuallyThread implements Callable<User> {
    @Override
    public User call() throws Exception {
        ArrayList<User> list = Runner.users;
        Thread.sleep(5000);
        for (User user: list) {
            if(user.id == Runner.value)return user;
        }
        return null;
    }

    void showList(ArrayList<User> list){
        for (User user: list) {
            System.out.println(user);
        }
    }
}