package com.payu.concurrency.practice.locking.caching;

import java.math.BigInteger;

public interface Factorizer {
    public void service(BigInteger reqInt) throws InterruptedException;
}
