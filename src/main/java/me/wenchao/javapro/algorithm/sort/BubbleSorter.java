package me.wenchao.javapro.algorithm.sort;

import java.util.Arrays;

/**
 * @Author wenchaofu
 * @DATE 15:27 2018/6/5
 * @DESC
 * @See https://blog.csdn.net/u010853261/article/details/54891710
 */
public class BubbleSorter implements Sort{
    public static void bubbleSorter(int[] a) {
        int length = a.length;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (a[j - 1] > a[j]) {
                    int tmp;
                    tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }

            }

        }
    }

    private static void bubbleSorter2(int[] a) {
        if (a == null && a.length == 1) return;
        int length = a.length;
        boolean sortFlag = true;
        while (sortFlag) {
            sortFlag = false;
            for (int i = 1; i < length; i++) {
                if (a[i - 1] > a[i]) {
                    int tmp;
                    tmp = a[i];
                    a[i] = a[i - 1];
                    a[i - 1] = tmp;
                    sortFlag = true;
                }
            }
            length--; //减少一次排序的尾边界
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 3, 12332, 343, 2, 7};
        bubbleSorter2(a);

        System.out.println(Arrays.toString(a));
    }

    @Override
    public void sort(int[] arr) {
        int length = arr.length;
        for (int i = 0; i < length; i++) {
            for (int j = 1; j < length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    int tmp;
                    tmp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = tmp;
                }

            }

        }
    }
}
