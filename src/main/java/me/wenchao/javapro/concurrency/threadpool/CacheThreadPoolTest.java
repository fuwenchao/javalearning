package me.wenchao.javapro.concurrency.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author wenchaofu
 * @DATE 17:28 2018/6/20
 * @DESC
 */
@Slf4j
public class CacheThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0 ; i <= 10;i++) {
            final int index = i;
            executor.execute(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("ThreadNum is {}", index);
            });
        }
        log.info("in main");
        executor.shutdown();
        log.info("in main2");
    }
}
