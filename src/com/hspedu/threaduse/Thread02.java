package com.hspedu.threaduse;

/**
 * @Author Agony
 * @Create 2023/2/16 19:29
 * @Version 1.0
 * 通过实现Runnable实现多线程
 */
public class Thread02 {

    public static void main(String[] args) {
        Dog dog = new Dog();
        Thread thread = new Thread(dog);
        thread.start();
    }
}

class Dog implements Runnable {

    @Override
    public void run() {
        int count = 0;
        while (true) {
            System.out.println("hi " + ++count + " " + Thread.currentThread().getName());

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