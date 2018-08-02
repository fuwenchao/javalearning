package me.wenchao.javabasic.thread;

/**
 * @Author wenchaofu
 * @DATE 9:49 2018/7/6
 * @DESC
 */
public class ThreadTest extends Thread {

    public static void main(String[] args) {

        String str = new String("hello");

        String after_str = "hello";

        System.out.println(str.intern() == after_str);

        String b = "计算机";
        String a = b + "软件";
        System.out.println(a.intern() == a);

    }
}
