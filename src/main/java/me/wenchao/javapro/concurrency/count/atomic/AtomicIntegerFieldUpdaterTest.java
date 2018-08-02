package me.wenchao.javapro.concurrency.count.atomic;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 * @Author wenchaofu
 * @DATE 10:05 2018/6/13
 * @DESC
 */
public class AtomicIntegerFieldUpdaterTest {
    private static AtomicIntegerFieldUpdater<AtomicIntegerFieldUpdaterTest> updater = AtomicIntegerFieldUpdater.newUpdater(AtomicIntegerFieldUpdaterTest.class
            ,"count");
    private volatile  int count = 100;

    private static AtomicIntegerFieldUpdaterTest atomicIntegerFieldUpdaterTest = new AtomicIntegerFieldUpdaterTest();

    public static void main(String[] args) {
        if (updater.compareAndSet(atomicIntegerFieldUpdaterTest, 100, 200)) {
            System.out.println("success");
            System.out.println("count is " + atomicIntegerFieldUpdaterTest.count);
        }
        if (updater.compareAndSet(atomicIntegerFieldUpdaterTest, 100, 300)) {
            System.out.println("success 2 ");
        } else {
            System.out.println("failed,count is " + atomicIntegerFieldUpdaterTest.count);
        }
    }

}
