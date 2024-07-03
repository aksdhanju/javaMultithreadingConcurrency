package com.payu.concurrency.practice.locking.caching;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicReference;

public class SafeCachingFactorizer implements Factorizer {

    private final AtomicReference<BigInteger> lastNumber = new AtomicReference<BigInteger>();
    private final AtomicReference<BigInteger> lastFactor = new AtomicReference<BigInteger>();

    public synchronized void service(BigInteger reqInt) throws InterruptedException {
        BigInteger i = extractFromRequest(reqInt);
        if (i.equals(lastNumber.get())) {
            encodeIntoResponse("Last was same req ", reqInt, lastFactor.get());
        }
        else {
            lastNumber.set(i);
            lastFactor.set(factor(i));
            encodeIntoResponse("Last was not same req ", lastNumber.get(), lastFactor.get());
        }
    }

    void encodeIntoResponse(String message, BigInteger reqInt, BigInteger factor) {
        System.out.println(message + " Req: " + reqInt + " Factors: " + factor);
    }

    BigInteger extractFromRequest(BigInteger reqInt) {
        return new BigInteger(reqInt.toString());
    }

    BigInteger factor(BigInteger i) {
        // Doesn't really factor
        return new BigInteger(i.toString());
    }

}
