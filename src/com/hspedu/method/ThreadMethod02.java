package com.hspedu.method;

/**
 * @Author Agony
 * @Create 2023/2/17 19:45
 * @Version 1.0
 */
public class ThreadMethod02 {
    public static void main(String[] args) throws InterruptedException {
        T2 t2 = new T2();
        t2.start();
        for (int i = 0; i < 20; i++) {
            Thread.sleep(200);
            System.out.println("main " + i);
            if (i == 5) {
                // t2.join();
                Thread.yield();
            }
        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("T2 " + i);
        }
    }
}