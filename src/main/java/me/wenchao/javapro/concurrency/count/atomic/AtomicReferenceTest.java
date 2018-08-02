package me.wenchao.javapro.concurrency.count.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author wenchaofu
 * @DATE 9:59 2018/6/13
 * @DESC
 */
public class AtomicReferenceTest {
    private static AtomicReference<Integer> atomicReference = new AtomicReference<>(0);

    public static void main(String[] args) {
        atomicReference.compareAndSet(0, 2);
        atomicReference.compareAndSet(2, 6);
        atomicReference.compareAndSet(5, 10);
        atomicReference.compareAndSet(6, 12);
        System.out.println(atomicReference.get());

    }
}
