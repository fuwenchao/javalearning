package me.wenchao.javabasic.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author wenchaofu
 * @DATE 17:00 2018/6/1
 * @DESC
 */
public class DaemonFromFacgtory implements Runnable{


    @Override
    public void run() {
        try {
            while (true) {
                TimeUnit.MILLISECONDS.sleep(100);
                System.out.println(Thread.currentThread().getName() + this);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "thread";
    }

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool(new DaemonThreadFactory());
        for (int i = 0; i < 10; i++) {
            executorService.execute(new DaemonFromFacgtory());
        }
        System.out.println("all daemond is started");
        TimeUnit.MILLISECONDS.sleep(1000);


    }
}
