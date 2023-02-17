package com.hspedu.method;

/**
 * @Author Agony
 * @Create 2023/2/17 19:55
 * @Version 1.0
 */
public class ThreadMethodExercise {
    public static void main(String[] args) throws InterruptedException {
        TT tt = new TT();
        Thread thread = new Thread(tt);

        for (int i = 1; i <= 10; i++) {
            Thread.sleep(1000);
            System.out.println("hi " + i);
            if (i == 5) {
                thread.start();
                thread.join();
            }
            if (i == 10) {
                System.out.println("主线程结束...");
            }
        }
    }
}

class TT implements Runnable {

    @Override
    public void run() {

        for (int i = 1; i <= 10; i++) {

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("hello " + i);
            if (i == 10) {
                System.out.println("子线程结束...");
            }
        }
    }
}