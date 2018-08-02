package me.wenchao.javapro.concurrency.AQS;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author wenchaofu
 * @DATE 16:33 2018/6/14
 * @DESC 这个程序不会自动退出，因为有一个线程会一直在等待 10 % 3
 */
public class CyclicBarrierTest {
    private static CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    public static void main(String[] args) throws Exception{

        ExecutorService executor = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            final int threadNum = i;
            executor.execute(() -> {
                try {
                    race(threadNum);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });

        }
        executor.shutdown();
    }

    private static void race(int threadNum) throws InterruptedException, BrokenBarrierException {
        Thread.sleep(2000);
//        System.out.println("thead " + threadNum + " is ready....");
        cyclicBarrier.await();
        System.out.println("thread " + threadNum + " is done");
    }
}
