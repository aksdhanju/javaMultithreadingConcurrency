package com.payu.concurrency.practice.sharing.threadlocal;

import java.util.concurrent.Callable;

public class NonThreadLocalCallable implements Callable {

    private Integer integer;

    public Object call() throws Exception {
        integer = ((int) (Math.random() * 50D));
        System.out.println(Thread.currentThread().getName()
                + " Going to sleep with object: " + integer.hashCode()
                + " and value set: " + integer);
        Thread.sleep(2000);
        return integer;
    }

}
