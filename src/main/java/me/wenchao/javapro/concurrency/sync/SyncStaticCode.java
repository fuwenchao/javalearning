package me.wenchao.javapro.concurrency.sync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author wenchaofu
 * @DATE 10:34 2018/6/13
 * @DESC
 */
public class SyncStaticCode {
    public static void main(String[] args) {
        SyncStaticCode syncBlockCode = new SyncStaticCode();
        SyncStaticCode syncBlockCode2 = new SyncStaticCode();
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(() ->{
            syncBlockCode.test(1);
        });
        executorService.execute(() ->{
            syncBlockCode2.test(2);  //不同对象
        });

        executorService.shutdown();
    }

    // 修饰静态方法
    private static synchronized void test2() {
        for (int i = 0; i < 10; i++) {
            System.out.println(" i is in test2 " + i);
        }
    }

    // 修饰类
    private static void test(int j) {
        synchronized (SyncStaticCode.class) {
            for (int i = 0; i < 10; i++) {
                System.out.println("test is " + j + " i  is " + i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
