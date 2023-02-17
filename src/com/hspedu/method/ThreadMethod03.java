package com.hspedu.method;

/**
 * @Author Agony
 * @Create 2023/2/17 20:10
 * @Version 1.0
 */
public class ThreadMethod03 {
    public static void main(String[] args) throws InterruptedException {
        MyDaememonThread myDaememonThread = new MyDaememonThread();
        myDaememonThread.setDaemon(true);
        myDaememonThread.start();
        for (int i = 1; i <= 10; i++) {
            System.out.println("主线程 " + i);
            Thread.sleep(1000);

        }
    }
}

class MyDaememonThread extends Thread {
    @Override
    public void run() {
        for (int i = 1; ; i++) {
            System.out.println("子线程" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}
