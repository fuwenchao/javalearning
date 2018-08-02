package me.wenchao.javabasic.collections;

/**
 * @Author wenchaofu
 * @DATE 15:14 2018/7/9
 * @DESC
 */
public class TestN {
    public static void main(String[] args) {
        System.out.println(sum());

    }

    private static double sum() {
        int sum = 1;
        int len = 0;
        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            if (sum < 400000) {
                sum = sum * 2;
                len++;
            } else {
                break;
            }

        }
        return sum*0.75;

    }
}
