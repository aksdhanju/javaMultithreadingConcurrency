package com.payu.concurrency.practice.threadpool.delay;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Example demonstrates who priority is calculated based on execution time
 * also covers usecase of scheduled threadpool for producer and consumer with delay.
 *
 * @author manish.ranglani
 */
public class DelayExampleMain {
    public static void main(String[] args) {
        DelayQueue<DelayedEvent> queue = new DelayQueue<>();
        AtomicInteger counter = new AtomicInteger();
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(2);
        ses.scheduleAtFixedRate(new DelayedEventProducer(queue, counter), 1, 2, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(new DelayedEventConsumer(queue), 1, 1, TimeUnit.SECONDS);
    }
}