package task2;

public class DaemonThread extends Thread{

    @Override
    public void run(){
        while (true) {
            System.out.print(".");
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
