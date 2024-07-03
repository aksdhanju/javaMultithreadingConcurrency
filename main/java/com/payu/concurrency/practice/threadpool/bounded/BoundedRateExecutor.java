package com.payu.concurrency.practice.threadpool.bounded;

import java.util.concurrent.*;

/**
 * Using a Semaphore to throttle task submission
 *
 * @author manish.ranglani
 */

public class BoundedRateExecutor {
    private final Executor exec;
    private final Semaphore semaphore;

    public BoundedRateExecutor(Executor exec, int bound) {
        this.exec = exec;
        this.semaphore = new Semaphore(bound);
    }

    public void submitTask(final Runnable command)
            throws InterruptedException {
        semaphore.acquire();
        try {
            exec.execute(new Runnable() {
                public void run() {
                    try {
                        command.run();
                    } finally {
                        semaphore.release();
                    }
                }
            });
        } catch (RejectedExecutionException e) {
            semaphore.release();
        }
    }
}
