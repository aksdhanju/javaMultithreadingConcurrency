package com.payu.concurrency.practice.sharing.visibility;

public class NoVisibilityUnSafe {
    private static boolean ready;
    private static int number;

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();

            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        ready = true;
        //Thread.sleep(500);
        number = 42;
    }
}
