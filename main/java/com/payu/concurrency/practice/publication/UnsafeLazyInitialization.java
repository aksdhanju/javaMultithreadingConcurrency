package com.payu.concurrency.practice.publication;


/**
 * UnsafeLazyInitialization: Unsafe lazy initialization
 *
 * @author manish.ranglani
 */
public class UnsafeLazyInitialization {
    private static Resource resource;

    public static Resource getInstance() {
        if (resource == null)
            resource = new Resource(); // unsafe publication
        return resource;
    }

    static class Resource {
    }
}