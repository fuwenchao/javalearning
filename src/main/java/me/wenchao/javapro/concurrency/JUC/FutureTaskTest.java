package me.wenchao.javapro.concurrency.JUC;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @Author wenchaofu
 * @DATE 11:21 2018/6/20
 * @DESC
 */
@Slf4j
public class FutureTaskTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        FutureTask<String> stringFutureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.info("do something");
                Thread.sleep(1000);
                log.info("do something is done");
                return "all thing is done";
            }
        });
        new Thread(stringFutureTask).start();
        log.info(" i am in main");
        Thread.sleep(1000);
        String s = stringFutureTask.get(); // 阻塞等待线程执行结束接着往下执行
        log.info("result is {}", s);


    }
}
