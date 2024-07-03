package com.payu.concurrency.practice.seq.gen;

public class SyncSequenceGenerator implements SequenceGenerator {
    private long value = 1;

    public synchronized long getNext() {
        return value++;
    }
}
