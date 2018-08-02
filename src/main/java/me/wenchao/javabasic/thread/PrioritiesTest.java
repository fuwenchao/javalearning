package me.wenchao.javabasic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author wenchaofu
 * @DATE 16:09 2018/6/1
 * @DESC
 */
public class PrioritiesTest implements Runnable {

    private int priorities;
    private String threadName;

    public PrioritiesTest(int priorities, String threadName) {
        this.priorities = priorities;
        this.threadName = threadName;
    }

    private int countDown = 5;
    private volatile double d;

    @Override
    public String toString() {
        return "PrioritiesTest{" +
                "priorities=" + priorities +
                ", threadName='" + threadName + '\'' +
                ", countDown=" + countDown +
                ", d=" + d +
                '}';
    }

    @Override
    public void run() {
        Thread.currentThread().setPriority(priorities);
        while(true){
            for (int i = 0; i < 5000; i++) {
                d += (Math.PI + Math.E) / (double)i;
                if (i % 1000 == 0) {
                    System.out.println(i);
                    Thread.yield();
                }
            }
            System.out.println(this);
            if (--countDown == 0) return;
        }

    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < 1; i++) {
            executorService.execute(new PrioritiesTest(Thread.MIN_PRIORITY,"low " + i));

        }
        executorService.execute(new PrioritiesTest(Thread.MIN_PRIORITY,"high "));
    }
}
