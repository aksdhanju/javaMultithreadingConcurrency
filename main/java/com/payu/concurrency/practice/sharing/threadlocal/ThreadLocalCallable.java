package com.payu.concurrency.practice.sharing.threadlocal;

import java.util.concurrent.Callable;

public class ThreadLocalCallable implements Callable {

    private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>();

    public Object call() throws Exception {
        threadLocal.set((int) (Math.random() * 50D));
        System.out.println(Thread.currentThread().getName()
                + " Going to sleep with object: " + threadLocal.hashCode()
                + " and value set: " + threadLocal.get());
        Thread.sleep(2000);
        return threadLocal.get();
    }

}
