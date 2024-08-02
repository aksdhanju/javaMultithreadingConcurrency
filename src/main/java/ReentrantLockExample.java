package main.java;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockExample {

    private final Lock lock = new ReentrantLock();

    public void sharedResourceMethod(int i) {
        lock.lock();
        try {
            // Critical section code
            System.out.println(Thread.currentThread().getName() + ": acquired the lock and is executing the critical section for i=" + i);
            Thread.sleep(1000); // Simulating work
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(Thread.currentThread().getName() + ": released the lock for i=" + i);
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockExample example = new ReentrantLockExample();

        Runnable task = () -> {
            for (int i = 0; i < 3; i++) {
                example.sharedResourceMethod(i);
            }
        };

        Thread thread1 = new Thread(task, "Thread-1");
        Thread thread2 = new Thread(task, "Thread-2");
        Thread thread3 = new Thread(task, "Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
