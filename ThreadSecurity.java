import java.util.Scanner;


class MyThread implements Runnable {
    public static int count = 0;

    public void run() {
        counting();
    }

    public void counting() {
        count++;
        System.out.println(count);
    }
}

public class ThreadSecurity {

    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            Thread thread = new Thread(new MyThread());
            thread.start();
        }
    }

}

