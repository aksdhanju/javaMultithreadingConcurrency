package com.payu.concurrency.practice.seq.gen;

import java.util.List;
import java.util.concurrent.*;

/**
 * Example explains how multi threads causes data loss and corruption.
 * Step1: Run and check output. data will be corrupted.
 * Step2: Comment 18 and uncomment 19 and run. Data should be printed as expected.
 * Step3: Try using atomic. Comment 18, 19 and uncomment 20.
 *
 * @author manish.ranglani
 */
public class SeqGenMain {

    public static void main(String[] args) {

        SequenceGenerator sequenceGenerator = new UnSafeSequenceGenerator();
        //SequenceGenerator sequenceGenerator = new SyncSequenceGenerator();
        //SequenceGenerator sequenceGenerator = new AtomicSequenceGenerator();

        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            // simulate 3 threads concurrent access the sequence generator
            Callable<List<Long>> task1 = new PrintSequenceCallable(sequenceGenerator);
            Callable<List<Long>> task2 = new PrintSequenceCallable(sequenceGenerator);
            Callable<List<Long>> task3 = new PrintSequenceCallable(sequenceGenerator);

            Future f1 = executor.submit(task1);
            Future f2 = executor.submit(task2);
            Future f3 = executor.submit(task3);

            System.out.println(f1.get());
            System.out.println(f2.get());
            System.out.println(f3.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }
    }
}


