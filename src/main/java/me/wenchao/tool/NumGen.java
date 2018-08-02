package me.wenchao.tool;

/**
 * @Author wenchaofu
 * @DATE 10:50 2018/6/26
 * @DESC
 */
public class NumGen {

    public static long mix64(long z) {
        z = (z ^ (z >>> 33)) * 0xff51afd7ed558ccdL;
        z = (z ^ (z >>> 33)) * 0xc4ceb9fe1a85ec53L;
        return z ^ (z >>> 33);
    }

    private static int mix32(long z) {
        z = (z ^ (z >>> 33)) * 0xff51afd7ed558ccdL;
        return (int)(((z ^ (z >>> 33)) * 0xc4ceb9fe1a85ec53L) >>> 32);
    }

    public static void main(String[] args) {
        System.out.println(mix64(10L));
        System.out.println(mix32(10));
    }

}
