package com.payu.concurrency.practice.check.then.act;

public interface CheckThenAct {
    SampleObject init(String message) throws InterruptedException;
}
