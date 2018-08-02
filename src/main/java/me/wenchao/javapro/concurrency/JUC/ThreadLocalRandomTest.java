package me.wenchao.javapro.concurrency.JUC;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @Author wenchaofu
 * @DATE 16:33 2018/6/22
 * @DESC
 */
public class ThreadLocalRandomTest {

    // 创建一个默认种子的随机数生成器
    private static ThreadLocalRandom random = ThreadLocalRandom.current();

    public static void main(String[] args) {
        int i = random.nextInt(10);
        System.out.println(i);
    }
}
