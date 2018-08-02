package me.wenchao.javabasic.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author wenchaofu
 * @DATE 16:27 2018/6/1
 * @DESC
 */
public class DaemonTest implements Runnable {

    private String threadName;

    public DaemonTest(String threadName) {
        this.threadName = threadName;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + threadName);
        try {
            while (true) {
                System.out.println("......");
                TimeUnit.MILLISECONDS.sleep(10);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            DaemonTest daemonTest = new DaemonTest(" " + i);
            Thread thread = new Thread(daemonTest);
            thread.setDaemon(true);
            thread.start();
        }
        System.out.println("all daemon ended ....");
//        TimeUnit.MILLISECONDS.sleep(174);
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
//                super.run();
                System.out.println("JVM 退出");
            }
        });
    }

}
