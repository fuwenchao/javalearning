package me.wenchao.javabasic.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Author wenchaofu
 * @DATE 15:40 2018/6/1
 * @DESC
 */
public class ExecutorServiceTest {
    public static void main(String[] args) {
        java.util.concurrent.ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 5; i++) {
            executorService.execute(new LiftOff());
        }
        System.out.println("******************");
        executorService.shutdown();
    }
}
