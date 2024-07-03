package com.payu.concurrency.practice.threadpool.cancel;


import static java.util.concurrent.TimeUnit.SECONDS;

import java.math.BigInteger;
import java.util.*;
import java.util.concurrent.*;


/**
 * ConstantGeneratorWithCancel
 * <p/>
 * Using a volatile field to hold cancellation state
 *
 * @author manish.ranglani
 */
public class ConstantGeneratorWithCancel implements Runnable {
    private static ExecutorService exec = Executors.newCachedThreadPool();

    private final List<BigInteger> primes = new ArrayList<BigInteger>();
    private volatile boolean cancelled;

    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<BigInteger>(primes);
    }

    static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        ConstantGeneratorWithCancel generator = new ConstantGeneratorWithCancel();
        exec.execute(generator);
        try {
            SECONDS.sleep(1);
        } finally {
            generator.cancel();
        }
        return generator.get();
    }
}