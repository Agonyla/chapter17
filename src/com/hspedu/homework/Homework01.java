package com.hspedu.homework;

import java.util.Scanner;

/**
 * @Author Agony
 * @Create 2023/2/18 10:29
 * @Version 1.0
 */
public class Homework01 {
    public static void main(String[] args) {
        A a = new A();
        B b = new B(a);
        a.start();
        b.start();
    }


}

class A extends Thread {
    public boolean loop = true;

    @Override
    public void run() {
        while (loop) {
            int num = (int) (Math.random() * 100 + 1);
            System.out.println(num);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

class B extends Thread {

    private A a;
    Scanner scanner = new Scanner(System.in);

    public B(A a) {
        this.a = a;
    }

    @Override
    public void run() {
        while (true) {
            char num = scanner.next().toLowerCase().charAt(0);
            if (num == 'q') {
                a.loop = false;
                break;
            }

        }
    }


}
