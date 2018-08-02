package me.wenchao.test;

/**
 * @Author wenchaofu
 * @DATE 9:28 2018/7/31
 * @DESC
 */
public class Recru {
    public static void main(String[] args) {
        int[] arr = {9,2,3,4,5,6};
        int sum = sum("all", arr, 0, arr.length - 1);
        System.out.println(sum);

    }
    private static int i = 0;

    public static int sum(String str ,int[] arr,int left,int right) {
        int sum = 0 ;
        if (left < right) {
            int mid = (left + right) / 2;
            int leftSum = sum("left",arr, left, mid);
            int rightSum = sum("right",arr, mid + 1, right);
            System.out.println("str is " + str + " i is " + i++ + " left is " + left + " right is " + right + " L " + leftSum + " " + rightSum);
            sum = sum(arr, left, mid, right);
        }

        return sum;
    }

    public static int sum(int[] arr, int left, int mid, int right) {
        System.out.println("in sum " + left + " " + mid + " " + right);
        int sum = 0;
        for (int i1 = 0; i1 < right + 1; i1++) {
            sum += arr[i1];

        }
        return sum;
    }
}

