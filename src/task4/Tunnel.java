package task4;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Tunnel {
    static AtomicInteger limit = new AtomicInteger(0);
    static boolean isOpen = false;

    int goIntoTunnel() throws InterruptedException {
        lock();
        int timeIntoTunnel = (int) (Math.random() * 5000);
        System.out.println(Thread.currentThread().getName() + " в'їхала в тунель");
        Thread.sleep(timeIntoTunnel);
        System.out.println(Thread.currentThread().getName() + " виїхав з тунелю, час: " + timeIntoTunnel);
        unlock();
        return timeIntoTunnel;
    }
    void lock() throws InterruptedException {
        synchronized (this) {
            if (limit.get() < 3) {
                limit.incrementAndGet();
            } else isOpen = true;
            while (isOpen) {
                wait();
            }
        }
    }

    void unlock() throws InterruptedException {
        synchronized (this) {
            limit.getAndSet(limit.get()-1);
            isOpen = false;
            notify();
        }
    }
}