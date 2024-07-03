package com.payu.concurrency.practice.sharing.threadlocal;

import java.util.concurrent.*;

/**
 *
 */
public class ThreadLocalMain {

    public static void main(String[] args) {

        ExecutorService executor = Executors.newCachedThreadPool();
        try {
            NonThreadLocalCallable callable = new NonThreadLocalCallable();
            //ThreadLocalCallable callable = new ThreadLocalCallable();

            Future f1 = executor.submit(callable);
            Future f2 = executor.submit(callable);
            Future f3 = executor.submit(callable);
            Future f4 = executor.submit(callable);

            System.out.println("Task 1 value: " + f1.get());
            System.out.println("Task 2 value: " + f2.get());
            System.out.println("Task 3 value: " + f3.get());
            System.out.println("Task 4 value: " + f4.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}


