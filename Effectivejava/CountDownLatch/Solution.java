package Effectivejava.CountDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhensheng on 2016/6/21.
 */
public class Solution {
    public static long time(Executor executor , int concurrency , final Runnable action ) throws InterruptedException {
        final CountDownLatch ready = new CountDownLatch(concurrency);
        final CountDownLatch start = new CountDownLatch(1);
        final CountDownLatch done = new CountDownLatch(concurrency);
        for (int i = 0; i <concurrency ; i++) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    ready.countDown();
                    try{
                        start.await();
                        action.run();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }finally {
                        done.countDown();
                    }
                }
            });
        }
        ready.await();
        long startNanos = System.nanoTime();
        start.countDown();
        done.await();
        return System.nanoTime()- startNanos;
    }
    public static void main(String []args) throws InterruptedException {
        System.out.println(time(Executors.newSingleThreadExecutor(),100, new Runnable() {
            @Override
            public void run() {

            }
        }));
    }


}
