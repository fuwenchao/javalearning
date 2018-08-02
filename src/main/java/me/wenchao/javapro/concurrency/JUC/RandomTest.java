package me.wenchao.javapro.concurrency.JUC;

import java.util.Random;

/**
 * @Author wenchaofu
 * @DATE 16:33 2018/6/22
 * @DESC
 */
public class RandomTest {

    // 创建一个默认种子的随机数生成器
    private static Random random = new Random();

    public static void main(String[] args) {
        int i = random.nextInt(10);
        System.out.println(i);
    }
}
