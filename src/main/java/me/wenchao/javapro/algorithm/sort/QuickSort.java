package me.wenchao.javapro.algorithm.sort;

import java.util.Arrays;

/**
 * @Author wenchaofu
 * @DATE 16:20 2018/6/11
 * @DESC 快速排序，冒泡排序的升级 分而治之的思想
 * 基本思想 ： 选择一个基准元素，通常是第一个或者最后一个，通过一趟扫描，将数组分为两部分，大的在基准的右边，小的在左边
 * 在近乎有序的数组中排序性能很差
 * 因为按照第一个元素分出来的树极度不平衡，如果是一个排序的数组，会退化为O(n^2)
 * 解决方法：随机取一个元素为标定元素
 */
public class QuickSort implements Sort{
    public static void main(String[] args) {
        int[] a = {12, 3, 212, 121, 12, 32, 4};
//        quickSort(a);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low > high) return;
        int i = low , j = high;
        int index = a[i];
        while (i < j) {
            while (i < j && a[j] > index)
                j--;
            if (i < j)
                a[i++] = a[j];
            while (i < j && a[i] <= index)
                i++;
            if (i < j)
                a[j--] = a[i];
        }
        a[i] = index;
        quickSort(a, low, i - 1);
        quickSort(a, i + 1, high);

    }

    private static void quickSort2(int[] a, int low, int high) {

        if (low > high) return;
        int i = low;
        int j = high;
        int index = a[i];
        while (i < j) {
            while (i < j && a[j] > index)
                j--;
            if (i < j)
                a[i++] = a[j];
            while (i < j && a[i] <= index)
                i++;
            if (i < j)
                a[j--] = a[i];
        }
        a[i] = index;
        quickSort(a, low, i - 1);
        quickSort(a, i + 1, high);


    }
}
