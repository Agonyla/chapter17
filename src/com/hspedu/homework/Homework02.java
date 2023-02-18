package com.hspedu.homework;

/**
 * @Author Agony
 * @Create 2023/2/18 10:55
 * @Version 1.0
 */
public class Homework02 {
    public static void main(String[] args) {
        Person person = new Person();
        Thread thread = new Thread(person);
        thread.setName("用户1");

        Thread thread1 = new Thread(person);
        thread1.setName("用户2");

        thread.start();
        thread1.start();

    }
}

class Person implements Runnable {

    public int balance = 10000;

    public synchronized void takeMoney() {


    }

    @Override
    public void run() {
        while (true) {

            synchronized (this) {
                if (balance <= 0) {
                    System.out.println("余额不足");
                    return;
                }
                balance -= 1000;
                System.out.println(Thread.currentThread().getName() + " 取走了1000元" + " 还剩 " + balance);

            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}