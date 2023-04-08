package task4;

import java.util.ArrayList;
import java.util.concurrent.Semaphore;

public class Race {
    public static void main(String[] args) throws InterruptedException {
        Semaphore carsIntoTheTunnel = new Semaphore(3);
//        Tunnel tunnel = new Tunnel();
        Car car1 = new Car();
        Car car2 = new Car();
        Car car3 = new Car();
        Car car4 = new Car();
        Car car5 = new Car();
        Car car6 = new Car();
        Car car7 = new Car();
        Car car8 = new Car();
        Car car9 = new Car();
        Car car10 = new Car();

        car1.setName("car1");
        car2.setName("car2");
        car3.setName("car3");
        car4.setName("car4");
        car5.setName("car5");
        car6.setName("car6");
        car7.setName("car7");
        car8.setName("car8");
        car9.setName("car9");
        car10.setName("car10");

//        car1.tunnel = tunnel;
//        car2.tunnel = tunnel;
//        car3.tunnel = tunnel;
//        car4.tunnel = tunnel;
//        car5.tunnel = tunnel;
//        car6.tunnel = tunnel;
//        car7.tunnel = tunnel;
//        car8.tunnel = tunnel;
//        car9.tunnel = tunnel;
//        car10.tunnel = tunnel;

        car1.carsIntoTheTunnel = carsIntoTheTunnel;
        car2.carsIntoTheTunnel = carsIntoTheTunnel;
        car3.carsIntoTheTunnel = carsIntoTheTunnel;
        car4.carsIntoTheTunnel = carsIntoTheTunnel;
        car5.carsIntoTheTunnel = carsIntoTheTunnel;
        car6.carsIntoTheTunnel = carsIntoTheTunnel;
        car7.carsIntoTheTunnel = carsIntoTheTunnel;
        car8.carsIntoTheTunnel = carsIntoTheTunnel;
        car9.carsIntoTheTunnel = carsIntoTheTunnel;
        car10.carsIntoTheTunnel = carsIntoTheTunnel;

        car1.start();
        car2.start();
        car3.start();
        car4.start();
        car5.start();
        car6.start();
        car7.start();
        car8.start();
        car9.start();
        car10.start();

        car1.join();
        car2.join();
        car3.join();
        car4.join();
        car5.join();
        car6.join();
        car7.join();
        car8.join();
        car9.join();
        car10.join();
        System.out.println("\n\n\n___________TOP___________");
        for (int i = 0; i < 10; i++) {
            System.out.println(Car.cars.get(i)+"\t\tчас: "+Car.times.get(i));
        }
    }
}
