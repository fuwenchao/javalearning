package me.wenchao.javapro.reference;

/**
 * @Author wenchaofu
 * @DATE 18:14 2018/5/15
 * @DESC
 */
import java.lang.ref.WeakReference;

public class WeakReferenceTest {

    public static void main(String[] args) throws Exception {
        WeakReference ref = new WeakReference(new MyDate());
//        ReferenceTest.drainMemory();
       System.gc(); //或者
//        在JVM垃圾回收运行时，弱引用被终止.

        System.out.println("=================");
//        Thread.sleep(1000);
//        test();
    }

    public static void test() throws Exception{
        Object o = new Object();
        // 默认的构造函数，会使用ReferenceQueue.NULL 作为queue
        WeakReference<Object> wr = new WeakReference<Object>(o);
        System.out.println(wr.get() == null);
        o = null;
        System.gc();
        System.out.println(wr.get() == null);
    }
}