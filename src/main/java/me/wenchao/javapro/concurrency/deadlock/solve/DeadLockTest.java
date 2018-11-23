package me.wenchao.javapro.concurrency.deadlock.solve;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author wenchaofu
 * @DATE 11:15 2018/7/12
 * @DESC
 */
public class DeadLockTest {
    // 如果在这里声明 Lock ，则A和B就不能并行
//    private static Lock lock = new ReentrantLock();

    public static class A {

        private static Lock lock = new ReentrantLock();

        public static void a1() throws InterruptedException {
            try{
                if(lock.tryLock(5,TimeUnit.SECONDS)) {
                    String name = Thread.currentThread().getName();
                    System.out.println(name + " --> this is a1");
                    B.b2();
                    TimeUnit.SECONDS.sleep(4);
                    System.out.println(name + " ---> a1 over");
                }

            } finally {
                lock.unlock();

            }

        }

        public static void a2() {
            try {
                if (lock.tryLock(4, TimeUnit.SECONDS)) {
                    System.out.println("this is a2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

    public static class B {
        private static Lock lock = new ReentrantLock();
        public static void b1() throws InterruptedException {

            try{
                if (lock.tryLock(5, TimeUnit.SECONDS)) {
                    String name = Thread.currentThread().getName();
                    System.out.println(name + " ---> this is b1");
                    A.a2();
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(name + " ---> b1 over");
                }

            }finally {

                lock.unlock();
            }

        }

        public  static void b2() {
            try {
                if (lock.tryLock(5, TimeUnit.SECONDS)) {
                    System.out.println("this is b2");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
