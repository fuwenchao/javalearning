package me.wenchao.javapro.concurrency.AQS;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author wenchaofu
 * @DATE 11:37 2018/6/14
 * @DESC
 */
public class SemaphoreTest3 {
    private static final int threadTotal = 100;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(3);

        CountDownLatch countDownLatch = new CountDownLatch(threadTotal);
        for (int i = 0; i < threadTotal; i++) {
            final int threadNum = i;
            executorService.execute(() -> {
                try {
                    if (semaphore.tryAcquire()) { // 0 1 2 3 个参数
                        add(threadNum);
                        semaphore.release();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                countDownLatch.countDown();
            });

        }
        countDownLatch.await();
        System.out.println("finished ----- ");
        executorService.shutdown();
    }

    private static void add(int threadNum) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("now is " + threadNum);
    }
}
