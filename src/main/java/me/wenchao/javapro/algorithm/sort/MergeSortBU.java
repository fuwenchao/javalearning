package me.wenchao.javapro.algorithm.sort;

import java.util.Arrays;

/**
 * @Author wenchaofu
 * @DATE 17:40 2018/6/11
 * @DESC 归并排序 自顶向下的算法
 * @See https://www.cnblogs.com/chengxiao/p/6194356.html
 */
public class MergeSortBU implements Sort {
    public static void main(String[] args) {
        int[] a = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("before sort " + Arrays.toString(a));
        new MergeSortBU().sort(a);
        System.out.println("after sort  " + Arrays.toString(a));

    }

    @Override
    public void sort(int[] a) {
        sort(a, a.length - 1);
    }

    private static void sort(int[] a, int n) {
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += sz + sz) {
                merge(a, i, i + sz - 1, Math.min(i + sz + sz - 1,n -1));

            }

        }
    }

    private static void merge(int[] a, int low, int mid, int high) {
        int[] temp = new int[high+1];

        int i = low;  //左序列指针
        int j = mid + 1; //右序列指针
        int t = 0; //临时数组指针
        while (i <= mid && j <= high) {
            if (a[i] > a[j]) {
                temp[t++] = a[j++];
            } else {
                temp[t++] = a[i++];
            }
        }
        while (i <= mid) {
            temp[t++] = a[i++];
        }
        while (j <= high) {
            temp[t++] = a[j++];
        }
        t = 0;
        while (low <= high) {
            a[low++] = temp[t++];
        }
    }
}
