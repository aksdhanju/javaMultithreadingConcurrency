package com.payu.concurrency.practice.sharing.visibility;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class NoVisibilitySafe {
    private static boolean ready;
    private static int number;

    private static final Lock lock = new ReentrantLock();

    private static class ReaderThread extends Thread {
        public void run() {
            while (!ready)
                Thread.yield();
            synchronized (lock) {
                System.out.println(number);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new ReaderThread().start();
        synchronized (lock) {
        ready = true;
        Thread.sleep(500);
        number = 42;
        }
    }
}
