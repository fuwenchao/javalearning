package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 9:20 2018/7/10
 * @DESC
 */
public class BitOpr {
    public static void main(String[] args) {
        int i = 1 << 30;
        System.out.println(i);
        String str = "abc";
        System.out.println(str.hashCode());
        int h = str.hashCode() >>> 20;
        System.out.println(h);
    }
}
