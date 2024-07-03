package com.payu.concurrency.practice.threadpool.delay;

import java.time.LocalDateTime;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.atomic.AtomicInteger;

class DelayedEventProducer implements Runnable {
    private final DelayQueue<DelayedEvent> queue;
    private AtomicInteger counter;

    public DelayedEventProducer(DelayQueue<DelayedEvent> queue, AtomicInteger counter) {
        this.queue = queue;
        this.counter = counter;
    }

    @Override
    public void run() {
        LocalDateTime now = LocalDateTime.now();
        int id = counter.incrementAndGet();
        DelayedEvent event = new DelayedEvent(id, "Task-" + id, now.minusSeconds(5));
        System.out.println(LocalDateTime.now() + " Added to queue :: " + event);
        int id1 = id + 1000;
        DelayedEvent event1 = new DelayedEvent(id1, "Task-" + id1, now.plusSeconds(2));
        System.out.println(LocalDateTime.now() + " Added to queue :: " + event1);
        queue.add(event);
        queue.add(event1);
    }
}
