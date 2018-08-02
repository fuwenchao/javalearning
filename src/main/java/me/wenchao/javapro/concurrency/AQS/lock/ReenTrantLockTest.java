package me.wenchao.javapro.concurrency.AQS.lock;

import me.wenchao.annotation.NotThreadSafe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author wenchaofu
 * @DATE 16:50 2018/6/12
 * @DESC
 */
@NotThreadSafe
public class ReenTrantLockTest {
    private volatile static int count = 0;
    private static int totalThread = 5000;
    private static int concurrencyThread = 200;

    private  static final Lock lock = new ReentrantLock();

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
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count is " + count);
    }


    private static void add() {
        lock.lock();
        try {
            count++;
        } finally {
            lock.unlock();
        }
    }

}
