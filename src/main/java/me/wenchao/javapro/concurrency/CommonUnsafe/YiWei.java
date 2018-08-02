package me.wenchao.javapro.concurrency.CommonUnsafe;

import java.util.concurrent.atomic.AtomicLong;

/**
 * @Author wenchaofu
 * @DATE 17:33 2018/6/25
 * @DESC
 */


public class YiWei {

    AtomicLong seed = new AtomicLong(10L);
    public static void main(String[] args) {
        int number = 10;
        //原始数二进制
        printInfo(number);
        System.out.println(number);
        System.out.println("============");
        number = number << 1;
        //左移一位
        printInfo(number);
        System.out.println(number);
        System.out.println("===========");
        number = number >> 2;
        //右移一位
        printInfo(number);
        System.out.println(number);
    }

    /**
     * 输出一个int的二进制数
     * @param num
     */
    private static void printInfo(int num){
        System.out.println(Integer.toBinaryString(num));
    }
}