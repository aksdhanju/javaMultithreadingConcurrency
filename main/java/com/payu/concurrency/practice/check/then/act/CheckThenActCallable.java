package com.payu.concurrency.practice.check.then.act;

import java.util.concurrent.Callable;

public class CheckThenActCallable implements Callable<SampleObject> {

    private CheckThenAct checkThenAct;
    private String message;

    public CheckThenActCallable(CheckThenAct checkThenAct, String message) {
        this.checkThenAct = checkThenAct;
        this.message = message;
    }

    public SampleObject call() throws Exception {
        return checkThenAct.init(message);
    }

}
