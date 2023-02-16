package com.hspedu.threaduse;

/**
 * @Author Agony
 * @Create 2023/2/16 18:45
 * @Version 1.0
 * 继承Thread 实现多线程
 */
public class Thread01 {
    public static void main(String[] args) throws InterruptedException {

        Cat cat = new Cat();
        cat.start();

        for (int i = 0; i < 70; i++) {
            System.out.println("i = " + i + "main线程" + Thread.currentThread().getName());
            Thread.sleep(1000);
        }
    }
}

class Cat extends Thread {

    int times = 0;

    @Override
    public void run() {

        while (true) {
            System.out.println("喵喵" + ++times + "Thread线程" + Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (times == 80) {
                break;
            }
        }

    }
}
