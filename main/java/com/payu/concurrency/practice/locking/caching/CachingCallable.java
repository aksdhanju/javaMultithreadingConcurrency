package com.payu.concurrency.practice.locking.caching;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class CachingCallable implements Callable {

    private Factorizer factorizer;
    private BigInteger integer;

    public CachingCallable(Factorizer factorizer, BigInteger integer) {
        this.factorizer = factorizer;
        this.integer = integer;
    }

    public Object call() throws Exception {
        factorizer.service(integer);
        return null;
    }

}
