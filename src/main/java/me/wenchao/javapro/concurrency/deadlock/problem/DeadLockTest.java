package me.wenchao.javapro.concurrency.deadlock.problem;

import java.util.concurrent.TimeUnit;

/**
 * @Author wenchaofu
 * @DATE 11:15 2018/7/12
 * @DESC
 */
public class DeadLockTest {
    public static class A {
        public synchronized static void a1() throws InterruptedException {
            String name = Thread.currentThread().getName();
            System.out.println(name + " --> this is a1");
            B.b2();
            TimeUnit.SECONDS.sleep(3);
            System.out.println(name + " ---> m1 over");
        }
        public synchronized static  void a2(){
            System.out.println("this is a2");
        }
    }

    public static class B {
        public synchronized static void b1() throws InterruptedException {
            String name = Thread.currentThread().getName();
            System.out.println(name + " ---> this is m2");
            A.a2();
            TimeUnit.SECONDS.sleep(2);
            System.out.println(name + " ---> m2 over");
        }
        public synchronized static void b2(){
            System.out.println("this is b2");
        }
    }
}
