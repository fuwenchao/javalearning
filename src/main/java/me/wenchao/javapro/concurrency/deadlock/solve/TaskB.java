package me.wenchao.javapro.concurrency.deadlock.solve;

/**
 * @Author wenchaofu
 * @DATE 11:16 2018/7/12
 * @DESC
 */
public class TaskB extends DeadLockTest implements Runnable {

    @Override
    public void run() {
        try {
            B.b1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
