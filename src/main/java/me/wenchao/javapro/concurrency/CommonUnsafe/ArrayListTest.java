package me.wenchao.javapro.concurrency.CommonUnsafe;

import me.wenchao.annotation.NotThreadSafe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author wenchaofu
 * @DATE 16:46 2018/6/13
 * @DESC
 */
@NotThreadSafe //两种方式变为线程安全，StringBuilder变为StringBuffer ；add 方法加上 synchronized 修饰
public class ArrayListTest {
    private static List<Integer> list = new ArrayList<>();
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
        System.out.println("count is " + list.size());
        ArrayList<Integer> integers = (ArrayList)list.subList(0, list.size());
        System.out.println(integers);
    }


    private  static void add(int i) {
        list.add(i);
    }


}
