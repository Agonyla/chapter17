package com.hspedu.synchronized_;

/**
 * @Author Agony
 * @Create 2023/2/16 20:29
 * @Version 1.0
 */
public class SellTicket {
    public static void main(String[] args) {
        // SellTicket01 sellTicket01 = new SellTicket01();
        // SellTicket01 sellTicket02 = new SellTicket01();
        // SellTicket01 sellTicket03 = new SellTicket01();
        // sellTicket01.start();
        // sellTicket02.start();
        // sellTicket03.start();

        // SellTicket02 sellTicket02 = new SellTicket02();
        // new Thread(sellTicket02).start();
        // new Thread(sellTicket02).start();
        // new Thread(sellTicket02).start();

        // SellTicket03 sellTicket03 = new SellTicket03();
        // new Thread(sellTicket03).start();
        // new Thread(sellTicket03).start();
        // new Thread(sellTicket03).start();

        SellTicket04 sellTicket041 = new SellTicket04();
        SellTicket04 sellTicket042 = new SellTicket04();
        SellTicket04 sellTicket043 = new SellTicket04();

        sellTicket041.start();
        sellTicket042.start();
        sellTicket043.start();
    }
}

class SellTicket01 extends Thread {

    private static int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票 还剩" + (--ticketNum));
        }

    }
}

class SellTicket02 implements Runnable {

    private static int ticketNum = 100;

    @Override
    public void run() {
        while (true) {
            if (ticketNum <= 0) {
                System.out.println("售票结束");
                break;
            }

            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票 还剩" + (--ticketNum));
        }

    }
}

class SellTicket03 implements Runnable {

    private static int ticketNum = 100;

    private boolean loop = true;

    public synchronized void sell() {
        if (ticketNum <= 0) {
            System.out.println("售票结束");
            loop = false;
            return;
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票 还剩" + (--ticketNum));
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }

    }
}

class SellTicket04 extends Thread {

    private static int ticketNum = 100;

    private static boolean loop = true;

    public static synchronized void sell() {
        if (ticketNum <= 0) {
            System.out.println("售票结束");
            loop = false;
            return;
        }

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("窗口" + Thread.currentThread().getName() + "售出一张票 还剩" + (--ticketNum));
    }

    @Override
    public void run() {
        while (loop) {
            sell();
        }

    }
}