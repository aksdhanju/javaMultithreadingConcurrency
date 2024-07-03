package com.payu.concurrency.practice.threadpool.delay;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.DelayQueue;

class DelayedEventConsumer implements Runnable {
    private final DelayQueue<DelayedEvent> queue;

    public DelayedEventConsumer(DelayQueue<DelayedEvent> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        List<DelayedEvent> events = new ArrayList<>();
        queue.drainTo(events);
        System.out.println("\n" + LocalDateTime.now() + " Event processing start **********\n");
        events.stream().forEach(delayedEvent -> {
            System.out.println(LocalDateTime.now() + " " + delayedEvent);
        });
        System.out.println("\n" + LocalDateTime.now() + " Event processing end **********\n");
    }
}
