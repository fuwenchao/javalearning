package me.wenchao.javapro.algorithm.sort;

import me.wenchao.tool.ArrayUtils;

import java.util.Arrays;

/**
 * @Author wenchaofu
 * @DATE 16:20 2018/6/11
 * @DESC 快速排序，冒泡排序的升级 分而治之的思想
 * 基本思想 ： 选择一个基准元素，通常是第一个或者最后一个，通过一趟扫描，将数组分为两部分，大的在基准的右边，小的在左边
 */
public class QuickSort2 implements Sort{
    public static void main(String[] args) {
        int[] a = {12, 3, 212, 121, 12, 32, 4};
        new QuickSort2().sort(a);
        System.out.println(Arrays.toString(a));
    }

    public void sort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static void quickSort(int[] a, int low, int high) {
        if (low >= high) {
            return;
        }
        int p = partitions(a, low, high);
        quickSort(a, low, p - 1);
        quickSort(a, p + 1, high);

    }

    private static int partitions(int[] a, int low, int high) {

        int j = low;
        int value = a[low];

        for (int i = low+1; i <= high; i++) {
            if (a[i] < value) {
                ArrayUtils.swap(a, j + 1, i);
                j++;
            }
        }
        ArrayUtils.swap(a,low,j);
        return j;

    }
}
