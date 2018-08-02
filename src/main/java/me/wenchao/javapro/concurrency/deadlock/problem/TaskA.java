package me.wenchao.javapro.concurrency.deadlock.problem;

/**
 * @Author wenchaofu
 * @DATE 11:16 2018/7/12
 * @DESC
 */
public class TaskA extends DeadLockTest implements Runnable {

    @Override
    public void run() {
        try {
            A.a1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
