package com.payu.concurrency.practice.seq.gen;

import java.util.concurrent.atomic.AtomicLong;

public class AtomicSequenceGenerator implements SequenceGenerator {

    private AtomicLong value = new AtomicLong(1);

    public long getNext() {
        return value.getAndIncrement();
    }
}
