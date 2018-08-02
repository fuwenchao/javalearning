package me.wenchao.javapro.concurrency.threadlocal;

/**
 * @Author wenchaofu
 * @DATE 16:07 2018/6/22
 * @DESC
 */
public class ThreadLocalTest {
    private static void print(String string) {
        System.out.println(string + "  -- " + localValue.get());
//        localValue.remove();
    }
    private static final ThreadLocal<String> localValue = new ThreadLocal<>();
    public static void main(String[] args) throws InterruptedException {
        // 声明两个线程
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                localValue.set("Thread One");
                print("threadone");
                System.out.println(localValue.get());


            }
        });
        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {
                localValue.set("Thread Two");
                print("threadtwo");
                System.out.println(localValue.get());

            }
        });
        threadOne.start();
        threadTwo.start();
        threadOne.join();
        threadTwo.join();
        System.out.println("game over");
    }
}
