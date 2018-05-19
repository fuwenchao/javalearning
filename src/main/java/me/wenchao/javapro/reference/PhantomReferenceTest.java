package me.wenchao.javapro.reference;

/**
 * @Author wenchaofu
 * @DATE 18:17 2018/5/15
 * @DESC
 */
import java.lang.ref.ReferenceQueue;
import java.lang.ref.PhantomReference;

public class PhantomReferenceTest {

    public static void main(String[] args) {
        ReferenceQueue queue = new ReferenceQueue();
        PhantomReference ref = new PhantomReference(new MyDate(), queue);
//        System.gc();
        ReferenceTest.drainMemory();
    }
}