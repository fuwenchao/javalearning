package me.wenchao.javapro.concurrency.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/**
 * @Author wenchaofu
 * @DATE 17:28 2018/6/20
 * @DESC 线程顺序执行
 */
@Slf4j
public class ScheduledThreadPoolTest {
    public static void main(String[] args) throws InterruptedException {
        ScheduledExecutorService executor = Executors.newScheduledThreadPool(3);
        // 延迟三秒执行
        /*for (int i = 0 ; i <= 10;i++) {
            final int index = i;
            executor.schedule(() -> {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                log.info("ThreadNum is {}", index);
            },3, TimeUnit.SECONDS);
        }*/

        //延迟1s,每隔3s调度执行一次，注意需要注释掉关闭线程池代码 executor.shutdown();
/*
        executor.scheduleAtFixedRate(() -> {
            log.info("schedule");
        }, 1, 3, TimeUnit.SECONDS);
*/


        log.info("in main");
//        executor.shutdown();

        // Timer实现每个5S 调度
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                log.info("timer running");
            }
        },new Date(),5*1000);
    }
}
