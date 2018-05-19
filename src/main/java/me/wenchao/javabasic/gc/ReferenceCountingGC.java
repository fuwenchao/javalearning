package me.wenchao.javabasic.gc;

/**
 * @Author wenchaofu
 * @DATE 15:40 2018/5/18
 * @DESC
 * -XX:+PrintGCDetails
 */
public class ReferenceCountingGC {
    public Object instance = null;
    private static final int _1MB = 1024*1024;

    //占用内存，以便观察GC情况
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC(){
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
        System.out.println("gc over");
    }


    public static void main(String[] args) {
        testGC();
    }

}
