package me.wenchao.javapro.concurrency.AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author wenchaofu
 * @DATE 11:37 2018/6/14
 * @DESC
 */
public class CountDownLatchTimeTest {
    private static final int threadTotal = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        CountDownLatch countDownLatch = new CountDownLatch(threadTotal);
        for (int i = 0; i < threadTotal; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                add(threadNum);
                countDownLatch.countDown();
            });

        }
        countDownLatch.await(10, TimeUnit.MILLISECONDS);
        System.out.println("finished ----- ");
        executorService.shutdown();
    }

    private static void add(int threadNum) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("now is " + threadNum);
    }
}
