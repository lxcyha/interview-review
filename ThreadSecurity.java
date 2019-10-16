import java.util.Scanner;
import java.util.concurrent.CountDownLatch;

public class ThreadSecurity implements Runnable {

    private static int count = 0;
    private static int threadCount = 100;
    private static CountDownLatch countDownLatch = new CountDownLatch(threadCount);

    public static void main(String[] args) {

        for (int i = 0; i < threadCount; i++) {
            Thread thread = new Thread(new ThreadSecurity());
            thread.start();
        }

        try {
            countDownLatch.await();
            System.out.println(count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        counting();
    }

    public void counting() {
        for (int i = 0; i < 100000; i++) {
            count++;
        }
        countDownLatch.countDown();
    }

}

