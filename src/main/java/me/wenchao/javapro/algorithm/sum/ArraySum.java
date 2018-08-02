package me.wenchao.javapro.algorithm.sum;

/**
 * @Author wenchaofu
 * @DATE 15:58 2018/7/5
 * @DESC 求 1+2+3+4+...+99 的值
 */
public class ArraySum {
    public static void main(String[] args) {
        System.out.println(sum2(99));
    }

    private static int sum(int maxNum) {
        if(maxNum<0){
            return 0;
        }
        return maxNum + sum(maxNum - 2);


    }

    private static int sum2(int maxNum){
        int sum = 0;
        for (int i = 1; i <= 99; i+=2) {
            sum += i;

        }
        return sum;
    }
}
