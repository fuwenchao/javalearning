package me.wenchao.javapro.concurrency.count.atomic;

import me.wenchao.annotation.NotThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author wenchaofu
 * @DATE 16:50 2018/6/12
 * @DESC
 */
@NotThreadSafe
public class AtomicBooleanTest {
    private static AtomicBoolean count = new AtomicBoolean(false);
    private static int totalThread = 5000;
    private static int concurrencyThread = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(concurrencyThread);
        final CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        for (int i = 0; i < totalThread; i++) {
                executorService.execute(() -> {

                    try {
                        semaphore.acquire();
                        test();
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                });
            countDownLatch.countDown();
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count is " + count.get());
    }

    private static void test() {
        if (count.compareAndSet(false,true)) {
            System.out.println("in test count is " + count.get());
        }
    }


}
