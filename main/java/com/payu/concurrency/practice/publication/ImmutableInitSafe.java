package com.payu.concurrency.practice.publication;

import java.util.HashMap;
import java.util.Map;

/**
 * Initialization safety for immutable objects
 *
 * @author manish.ranglani
 */
public class ImmutableInitSafe {
    private final Map<String, String> states;

    public ImmutableInitSafe() {
        states = new HashMap<>();
        states.put("alaska", "AK");
        states.put("alabama", "AL");
        /*...*/
        states.put("wyoming", "WY");
    }

    public String getAbbreviation(String s) {
        return states.get(s);
    }
}
