package me.wenchao.javapro.algorithm.sort;

import java.util.Arrays;

/**
 * @Author wenchaofu
 * @DATE 17:40 2018/6/11
 * @DESC 归并排序 自顶向下的算法
 * @See https://www.cnblogs.com/chengxiao/p/6194356.html
 */
public class MergeSort3 implements Sort {
    public static void main(String[] args) {
        int[] a = {8, 7, 6, 5, 4, 3, 2, 1};
        System.out.println("before sort " + Arrays.toString(a));
        new MergeSort3().sort(a);
        System.out.println("after sort  " + Arrays.toString(a));

    }

    @Override
    public void sort(int[] a) {
        int[] temp = new int[a.length];
        sort(a, 0, a.length - 1, temp);
    }

    private static void sort(int[] a, int low, int high, int[] temp) {
        // 如果区间小于15的话，就转换为插入排序算法，但是这种优化并不好，甚至更差，不建议 采用
        if (high - low < 15) {
            new InsertSort2().sort(a,low,high);
            return;
        }
        int mid = (low + high) / 2;
        sort(a, low, mid, temp);
        sort(a, mid + 1, high, temp);
        if (a[mid] > a[mid + 1]) // 如果大的话才归并，在近乎有序的数组中效果明显
            merge(a, low, mid, high, temp);
//            System.out.println("sorting     " + Arrays.toString(a));
    }

    private static void merge(int[] a, int low, int mid, int high, int[] temp) {
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
