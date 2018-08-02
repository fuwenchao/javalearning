package me.wenchao.javapro.algorithm.sum;

/**
 * @Author wenchaofu
 * @DATE 16:21 2018/7/4
 * @DESC
 */
public class RecSum {
    public static void main(String[] args) {
        System.out.println(sum(6));
    }

    private static int sum(int number) {
        if (number == 1) {
            return 1;

        } else {
            return number * sum(number - 1);
        }
    }
}
