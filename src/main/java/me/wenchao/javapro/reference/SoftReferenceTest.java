package me.wenchao.javapro.reference;


import java.lang.ref.SoftReference;

/**
 * @Author wenchaofu
 * @DATE 18:12 2018/5/15
 * @DESC
 */

public class SoftReferenceTest {

    /*
    SoftReference ref = new SoftReference(new MyDate());
ReferenceTest.drainMemory();

等价于

MyDate date = new MyDate();

// 由JVM决定运行
If(JVM.内存不足()) {
date = null;
System.gc();
}
     */

    //没有结果应该是虽然ReferenceTest.drainMemory()占用了一些内存，但还没有让JVM觉得内存不够用的程度，所以软引用关联的对象不会被回收，如果在运行时设置JVM参数 -Xmx，限制最大堆内存，就能达到效果。
//    -Xmx1M
    public static void main(String[] args) throws InterruptedException {
        MyDate md = new MyDate();
        UseDate ud = new UseDate(md);
//        SoftReference ref = new SoftReference(md);
        ReferenceTest.drainMemory();
//        System.gc();
        Thread.sleep(1000);
    }
}