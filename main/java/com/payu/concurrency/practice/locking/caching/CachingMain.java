package com.payu.concurrency.practice.locking.caching;

import com.payu.concurrency.practice.check.then.act.*;

import java.math.BigInteger;
import java.util.concurrent.*;

/**
 * Example features safe and unsafe caching technique and how atomic var are partial safe.
 * action:
 * Step1: Execute program check out put. See how factors are mismatched abd value read by threads.
 * Step2: Comment 26 to 29 & uncomment 32 to 35. Run and check output.
 *
 * @author manish.ranglani
 */
public class CachingMain {

    public static void main(String[] args) {

        Factorizer factorizer = new UnsafeCachingFactorizer();
        Factorizer safeFactorizer = new SafeCachingFactorizer();
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            // unsafe check and then act
            Callable<SampleObject> task1 = new CachingCallable(factorizer, new BigInteger("1"));
            Callable<SampleObject> task2 = new CachingCallable(factorizer, new BigInteger("1"));
            Callable<SampleObject> task3 = new CachingCallable(factorizer, new BigInteger("2"));
            Callable<SampleObject> task4 = new CachingCallable(factorizer, new BigInteger("2"));

            //Safe check and then act
            //Callable<SampleObject> task1 = new CachingCallable(safeFactorizer, new BigInteger("1"));
            //Callable<SampleObject> task2 = new CachingCallable(safeFactorizer, new BigInteger("1"));
            //Callable<SampleObject> task3 = new CachingCallable(safeFactorizer, new BigInteger("2"));
            //Callable<SampleObject> task4 = new CachingCallable(safeFactorizer, new BigInteger("2"));

            Future f1 = executor.submit(task1);
            Future f2 = executor.submit(task2);
            Future f3 = executor.submit(task3);
            Future f4 = executor.submit(task4);

            f1.get();
            f2.get();
            f3.get();
            f4.get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }
}