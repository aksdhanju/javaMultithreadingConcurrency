package com.payu.concurrency.practice.publication;

/**
 * SafeLazyInitialization: Thread-safe lazy initialization
 *
 * @author manish.ranglani
 */
public class SafeLazyInitialization {
    private static Resource resource;

    public synchronized static Resource getInstance() {
        if (resource == null)
            resource = new Resource();
        return resource;
    }

    static class Resource {
    }
}
