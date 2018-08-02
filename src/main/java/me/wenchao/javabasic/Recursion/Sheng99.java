package me.wenchao.javabasic.Recursion;

/**
 * @Author wenchaofu
 * @DATE 11:06 2018/7/9
 * @DESC
 */
public class Sheng99 {

    public static void main(String[] args) {

        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " * " + i + " = " + (i * j) + "; ");
            }
            System.out.println();
        }
        System.out.println("===========");
        m(9);
    }

    /**
     * 打印出九九乘法表
     *
     * @param i
     */
    public static void m(int i) {
        if (i == 1) {
            System.out.println("1*1=1 ");
        } else {
            m(i - 1);
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + " ");
            }
            System.out.println();
        }
    }

}