package me.wenchao.javapro.concurrency.JUC;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

/**
 * @Author wenchaofu
 * @DATE 11:15 2018/6/20
 * @DESC
 */
@Slf4j
public class FutureTest {
    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            log.info(" do something ");
            Thread.sleep(1000);
            return "done";
        }

    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<String> result = executorService.submit(new MyCallable());
        log.info("do something in main");
        Thread.sleep(1000);
        String s = result.get();
        log.info("result is {}", s);


    }
}
