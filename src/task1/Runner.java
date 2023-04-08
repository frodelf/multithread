package task1;

public class Runner {
    private static Object monitor = new Object();
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread A = new Thread(new Runnable() {
            @Override
            public void run() {
                    for (int i = 0; i < 5; i++) {
                        synchronized (monitor) {
                            while (count % 3 != 0) {
                                try {
                                    monitor.wait();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            System.out.print("A");
                            count++;
                            monitor.notifyAll();
                        }
                    }
            }
        });

        Thread B = new Thread(new Runnable() {
            @Override
            public void run() {
                    for (int i = 0; i < 5; i++) {
                        synchronized (monitor) {
                            while (count % 3 != 1) {
                                try {
                                    monitor.wait();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            System.out.print("B");
                            count++;
                            monitor.notifyAll();
                        }
                    }
            }
        });

        Thread C = new Thread(new Runnable() {
            @Override
            public void run() {
                    for (int i = 0; i < 5; i++) {
                        synchronized (monitor) {
                            while (count % 3 != 2) {
                                try {
                                    monitor.wait();
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }
                            }
                            System.out.print("C");
                            count++;
                            monitor.notifyAll();
                        }
                    }

            }
        });

        A.start();
        B.start();
        C.start();
    }
}
