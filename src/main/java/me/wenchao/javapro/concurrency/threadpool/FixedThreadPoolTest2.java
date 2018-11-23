package me.wenchao.javapro.concurrency.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author wenchaofu
 * @DATE 17:28 2018/6/20
 * @DESC 在线程池中保持三个线程可以同时执行
 */
@Slf4j
public class FixedThreadPoolTest2 {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        try {
            for (int i = 0; i <= 10; i++) {
                int index = i;
                executor.execute(() -> {
                    try {
                        Thread.sleep(1000);
                        if (index == 5) {
//                            throw new Exception("exp");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    log.info("ThreadNum is {}", index);
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        log.info("in main");
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.HOURS);
    }
}
