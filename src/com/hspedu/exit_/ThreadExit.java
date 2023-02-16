package com.hspedu.exit_;

/**
 * @Author Agony
 * @Create 2023/2/16 20:45
 * @Version 1.0
 */
public class ThreadExit {
    public static void main(String[] args) throws InterruptedException {
        T t = new T();
        t.start();

        Thread.sleep(10 * 1000);

        t.setLoop(false);

    }
}

class T extends Thread {
    private int count = 0;
    private boolean loop = true;

    @Override
    public void run() {
        while (loop) {

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("T 在运行中" + ++count);
        }
    }

    public void setLoop(boolean loop) {
        this.loop = loop;
    }
}