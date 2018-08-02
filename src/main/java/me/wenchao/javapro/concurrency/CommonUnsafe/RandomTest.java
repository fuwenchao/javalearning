package me.wenchao.javapro.concurrency.CommonUnsafe;

import me.wenchao.annotation.NotRecommend;
import me.wenchao.annotation.ThreadSafe;

import java.util.Random;

/**
 * @Author wenchaofu
 * @DATE 17:08 2018/6/25
 * @DESC
 */
@ThreadSafe
@NotRecommend
public class RandomTest {
    static Random random = new Random();

    public static void main(String[] args) {
        System.out.println(random.nextInt(10));
    }
}
