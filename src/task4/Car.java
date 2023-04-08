package task4;

import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class Car extends Thread{
    Semaphore carsIntoTheTunnel;
//    Tunnel tunnel;
    static AtomicBoolean allCarsIsReady = new AtomicBoolean(false);
    public static CopyOnWriteArrayList<String> cars = new CopyOnWriteArrayList<>();
    public static CopyOnWriteArrayList<Integer> times = new CopyOnWriteArrayList<>();
    public static AtomicInteger carsWhoAreReady = new AtomicInteger(0);

    @Override
    public void run() {

        int readying = ((int) (Math.random()*5000));
        System.out.println(Thread.currentThread().getName()+" почав підготовку до гонки, час підготовки: "+readying);
        try {
            Thread.sleep(readying);
            System.out.println(Thread.currentThread().getName()+" закінчив підготовку");

            synchronized (this) {
                if (carsWhoAreReady.incrementAndGet() < 10) {
                    stopThread();
                }
            }
            allCarsIsReady.getAndSet(true);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(Thread.currentThread().getName()+" стартував");
        long allTime = System.currentTimeMillis();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int firstSection = ((int) (Math.random()*5000));
        try {
            Thread.sleep(firstSection);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(Thread.currentThread().getName() + " проїхав перший проміжок за:" + firstSection);


        int timeIntoTunnel = ((int) (Math.random() * 5000));
        try {
            carsIntoTheTunnel.acquire();
            System.out.println(Thread.currentThread().getName() + " в'їхала в тунель");
            Thread.sleep(timeIntoTunnel);
            System.out.println(Thread.currentThread().getName() + " виїхав з тунелю, час: " + timeIntoTunnel);
            carsIntoTheTunnel.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        System.out.println(Thread.currentThread().getName()+" на останьому проміжку дороги");
        int lastSection = ((int)(int) (Math.random()*5000));
        try {
            Thread.sleep(lastSection);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println(Thread.currentThread().getName() + " проїхав останій проміжок за:" + lastSection);

        //int allTime = firstSection + timeIntoTunnel + lastSection;
        System.out.println("Час усього заїзду " + Thread.currentThread().getName()+", рівен: "+(System.currentTimeMillis()-allTime));

        cars.add(Thread.currentThread().getName());
        times.add((int) (System.currentTimeMillis()-allTime));
    }

   void stopThread(){
        while (!allCarsIsReady.get());
   }
}
