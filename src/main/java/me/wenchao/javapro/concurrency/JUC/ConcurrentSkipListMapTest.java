package me.wenchao.javapro.concurrency.JUC;

import me.wenchao.annotation.ThreadSafe;

import java.util.Map;
import java.util.concurrent.*;

/**
 * @Author wenchaofu
 * @DATE 16:46 2018/6/13
 * @DESC
 */
@ThreadSafe
public class ConcurrentSkipListMapTest {
    private static Map<Integer,Integer> map = new ConcurrentSkipListMap<>();
    private static int totalThread = 5000;
    private static int concurrencyThread = 200;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore semaphore = new Semaphore(concurrencyThread);
        CountDownLatch countDownLatch = new CountDownLatch(totalThread);
        for (int i = 0; i < totalThread; i++) {
            final int count = i;
            executorService.execute(() -> {
                try {
                    semaphore.acquire();
                    add(count);
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                countDownLatch.countDown();  //这个要放在线程里面执行，不要放在for里面
            });
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count is " + map.size());
    }


    private  static void add(int i) {
        map.put(i,i);
    }

}
