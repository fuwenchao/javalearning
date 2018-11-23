package me.wenchao.javapro.algorithm;

/**
 * @Author wenchaofu
 * @DATE 10:43 2018/8/6
 * @DESC
 */
public class rec99 {
    public static void main(String args[]) {
        m(9);
    }

    /**
     * 打印出九九乘法表
     * @param i
     */
    public static void m(int i) {
        if (i == 1) {
            System.out.println("1*1=1 ");
        } else {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + j * i + " ");
            }
            System.out.println();

            m(i - 1);

        }
    }
}