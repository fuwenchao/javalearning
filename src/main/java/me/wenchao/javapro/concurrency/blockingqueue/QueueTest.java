package me.wenchao.javapro.concurrency.blockingqueue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author wenchaofu
 * @DATE 14:35 2018/7/12
 * @DESC
 */
public class QueueTest {
    public static void main(String[] args) {
        // 一定要指定长度
        BlockingQueue<String> stringArrayBlockingQueue = new ArrayBlockingQueue<String>(5);
        for (int i = 0; i < 10; i++) {
            stringArrayBlockingQueue.add("A");
        }

    }
}
