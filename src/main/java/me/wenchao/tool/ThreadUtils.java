package me.wenchao.tool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author wenchaofu
 * @DATE 16:10 2018/7/11
 * @DESC
 */
public class ThreadUtils {
    public static void RunTasks(Class<? extends Runnable> clz) throws IllegalAccessException, InstantiationException, InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        System.out.println("begin to execute " + clz.getSimpleName() + " task ****");
        // 启动三个线程
        for (int i = 0; i < 3; i++) {
            executorService.submit(clz.newInstance());
        }
        // 等待一定时间，然后关闭线程
        TimeUnit.SECONDS.sleep(10);
        System.out.println("end to execute " + clz.getSimpleName() + " task ****");
        executorService.shutdown();

    }
}
