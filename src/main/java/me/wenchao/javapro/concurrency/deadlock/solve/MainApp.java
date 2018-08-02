package me.wenchao.javapro.concurrency.deadlock.solve;

/**
 * @Author wenchaofu
 * @DATE 11:18 2018/7/12
 * @DESC  全部换成Lock，增加超时时间解决死锁问题；tryLock 实现了自旋锁
 */
public class MainApp {
    public static void main(String[] args) {
        TaskA taskA = new TaskA();
        TaskB taskB = new TaskB();
        // 在这里，如果传的是同一个task对象的话 就可以实现同步，但是不是说sync是类级别的同步吗
        Thread t = new Thread(taskA);
        Thread t2 = new Thread(taskB);
        t.start();
        t2.start();
    }
}
