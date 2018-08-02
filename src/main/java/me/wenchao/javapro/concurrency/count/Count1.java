package me.wenchao.javapro.concurrency.count;

import me.wenchao.annotation.NotThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author wenchaofu
 * @DATE 16:50 2018/6/12
 * @DESC CountDownLatch 有一个比较好的栗子，参见 高质量编程 建议130（P266）
 */
@NotThreadSafe
public class Count1 {
    private volatile static int count = 0;
    private static int totalThread = 5000;
    private static int concurrencyThread = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(concurrencyThread);
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add();
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                countDownLatch.countDown();  //这个要放在线程里面执行，不要放在for里面
            });
        }
        countDownLatch.await();  // 等待count为0
        executorService.shutdown();
        System.out.println("count is " + count);
    }


    private synchronized static void add() {
        count++;
    }

}
