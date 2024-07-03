package com.payu.concurrency.practice.check.then.act;

/**
 * init method is not safe. May result into multiple initializations.
 *
 * @author manish.ranglani
 */
public class UnSafeCheckThenAct implements CheckThenAct {

    private SampleObject object = null;

    public SampleObject init(String message) {
        if (object == null) {
            object = new SampleObject(message);
        }
        return object;
    }
}
