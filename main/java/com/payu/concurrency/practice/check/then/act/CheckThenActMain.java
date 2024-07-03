package com.payu.concurrency.practice.check.then.act;

import java.util.concurrent.*;

/**
 * Example to execute safe and unsafe check then act with race conditions.
 * Step 1: Run and confirm if multiple objects created.
 * Step 2: Uncomment line 31 and run again
 * Step 3: Comment line 23 & 24. uncomment line 27 & 28 and run.
 *
 * @author manish.ranglani
 */
public class CheckThenActMain {

    public static void main(String[] args) {

        CheckThenAct checkThenAct = new UnSafeCheckThenAct();
        CheckThenAct safeCheckThenAct = new SafeCheckThenAct();
        ExecutorService executor = Executors.newCachedThreadPool();

        try {
            // unsafe check and then act
            Callable<SampleObject> task1 = new CheckThenActCallable(checkThenAct, "I am thread 1");
            Callable<SampleObject> task2 = new CheckThenActCallable(checkThenAct, "I am thread 2");

            //Safe check and then act
            //Callable<SampleObject> task1 = new CheckThenActCallable(safeCheckThenAct, "I am thread 1");
            //Callable<SampleObject> task2 = new CheckThenActCallable(safeCheckThenAct, "I am thread 2");

            Future f1 = executor.submit(task1);
            //Thread.sleep(2000);
            Future f2 = executor.submit(task2);

            System.out.println(f1.get());
            System.out.println(f2.get());

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } finally {
            executor.shutdown();
        }

    }

}


