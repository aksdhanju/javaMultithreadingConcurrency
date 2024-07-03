package com.payu.concurrency.practice.seq.gen;

public class UnSafeSequenceGenerator implements SequenceGenerator {
    private long value = 1;

    public long getNext() {
        return value++;
    }
}
