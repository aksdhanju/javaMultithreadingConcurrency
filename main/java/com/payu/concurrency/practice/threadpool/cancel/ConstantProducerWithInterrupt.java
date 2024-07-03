package com.payu.concurrency.practice.threadpool.cancel;

import java.math.BigInteger;
import java.util.concurrent.*;

/**
 * ConstantProducer
 * <p/>
 * Using interruption for cancellation
 *
 * @author
 */
public class ConstantProducerWithInterrupt extends Thread {
    private final BlockingQueue<BigInteger> queue;

    ConstantProducerWithInterrupt(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    public void run() {
        try {
            BigInteger p = BigInteger.ONE;
            while (!Thread.currentThread().isInterrupted())
                queue.put(p = p.nextProbablePrime());
        } catch (InterruptedException consumed) {
            System.out.println("Thread interrupted. Time to exit!");
        }
    }

    public void cancel() {
        interrupt();
    }
}
