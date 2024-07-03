package com.payu.concurrency.practice.check.then.act;

/**
 * init method is synchronized to allow safe initialization
 *
 * @author manish.ranglani
 */
public class SafeCheckThenAct implements CheckThenAct {

    private SampleObject object = null;

    public synchronized SampleObject init(String message) {
        if (object == null) {
            object = new SampleObject(message);
        }
        return object;
    }
}
