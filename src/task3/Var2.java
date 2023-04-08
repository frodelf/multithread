package task3;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerArray;

public class Var2 {
    static AtomicIntegerArray array = new AtomicIntegerArray(20001);
    static AtomicInteger index = new AtomicInteger(0);
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

        System.out.println(index.get());
        System.out.println(array.get(index.get()));
    }

    static void doWork(){
        array.set(index.incrementAndGet(), (int) (Math.random()*100));
    }
}
