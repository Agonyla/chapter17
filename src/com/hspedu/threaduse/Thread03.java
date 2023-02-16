package com.hspedu.threaduse;

/**
 * @Author Agony
 * @Create 2023/2/16 20:16
 * @Version 1.0
 */
public class Thread03 {
    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }
}

class T1 extends Thread {
    @Override
    public void run() {

        int count = 0;
        while (true) {
            System.out.println("hello " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 10) {
                break;
            }

        }
    }
}

class T2 extends Thread {
    @Override
    public void run() {

        int count = 0;
        while (true) {
            System.out.println("hi " + (++count));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (count == 5) {
                break;
            }
        }
    }
}