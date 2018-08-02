package me.wenchao.javapro.concurrency.AQS;

import java.util.concurrent.*;

/**
 * @Author wenchaofu
 * @DATE 16:33 2018/6/14
 * @DESC
 */
public class CyclicBarrierLamdaTest2 {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3,() ->{
        //线程到达屏障的时候优先执行这个.也就是 有了 3 个 await 先执行这个。
        System.out.println("callback is running");
    });
    public static void main(String[] args) throws Exception{

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            final int threadNum = i;
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (InterruptedException  e) {
                    e.printStackTrace();
                }
            });

        }
        executor.shutdown();
    }

    private static void race(int threadNum) throws InterruptedException {
        Thread.sleep(200);
//        System.out.println("thead " + threadNum + " is ready....");
        try {
            cyclicBarrier.await();
        } catch (BrokenBarrierException e) {
            // 这里捕获异常不会影响到后面的程序执行
        }
        System.out.println("thread " + threadNum + " is done");
    }
}
