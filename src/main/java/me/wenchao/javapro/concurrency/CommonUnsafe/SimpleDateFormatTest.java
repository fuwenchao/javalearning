package me.wenchao.javapro.concurrency.CommonUnsafe;

import me.wenchao.annotation.NotThreadSafe;
import org.joda.time.format.DateTimeFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @Author wenchaofu
 * @DATE 16:50 2018/6/13
 * @DESC
 */

/**
 * 变为线程安全的方法
 * 1. 将 SimpleDateFormat的声明放在add方法中
 */
@NotThreadSafe
public class SimpleDateFormatTest {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");  // 将声明对象放入add中可变为线程安全
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
        countDownLatch.await();
        executorService.shutdown();
    }


    private  static void add() {
        try {
            simpleDateFormat.parse("20180613");
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

}