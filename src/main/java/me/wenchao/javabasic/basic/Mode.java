package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 10:11 2018/6/29
 * @DESC
 */
public class Mode {
    public static void main(String[] args) {
        System.out.println(mode(-3,2));
        System.out.println(10 - 9.8);
        System.out.println(2147483647 + 2);
    }

    private static int mode(int i, int i1) {

        return i - i / i1 * i1;
    }
}
