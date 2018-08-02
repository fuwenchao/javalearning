package me.wenchao.javapro.concurrency.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author wenchaofu
 * @DATE 10:34 2018/6/13
 * @DESC
 */
public class SyncBlockCode {
    public static void main(String[] args) {
        SyncBlockCode syncBlockCode = new SyncBlockCode();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() ->{
            syncBlockCode.test();
        });
        executorService.execute(() ->{
            syncBlockCode.test();
        });

    }

    // 修饰方法
    private synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            System.out.println(" i is in test2 " + i);
        }
    }

    // 修饰代码块
    private void test() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                System.out.println("i is in test" + i);
            }
        }
    }


}
