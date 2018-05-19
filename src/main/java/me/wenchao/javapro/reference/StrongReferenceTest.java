package me.wenchao.javapro.reference;

/**
 * @Author wenchaofu
 * @DATE 18:11 2018/5/15
 * @DESC
 */

public class StrongReferenceTest {

    public static void main(String[] args) throws InterruptedException {
        MyDate date = new MyDate();
        date = null;
        System.gc();
//        Thread.sleep(10000);

    }
}