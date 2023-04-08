package task3;

import java.util.ArrayList;

public class Var1 {
    static ArrayList<Double> list = new ArrayList<>();
    public static void main(String[] args) throws InterruptedException {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    doWork();
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    doWork();
                }
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(list.size());
    }

    static synchronized void doWork(){
        list.add(Math.random());
    }
}
