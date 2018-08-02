package me.wenchao.javapro.algorithm.sort;

import com.sun.deploy.util.ArrayUtil;
import me.wenchao.tool.ArrayUtils;

import java.util.Arrays;

/**
 * @Author wenchaofu
 * @DATE 17:54 2018/6/8
 * @DESC 每一步将一个待排序的记录，插入到前面已经排好序的有序序列中去，直到插完所有元素为止。
 */
public class InsertSort implements Sort {
    public static void main(String[] args) {
        int[] a = {12, 3, 212, 43, 21, 6, 988,5};
        System.out.println(Arrays.toString(a));
    }

    // bad
    public void sort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        for (int i = 1; i < a.length; i++) {
            for (int j = i; j > 0 && a[j - 1] > a[j]; j--) {
//                    swap(a[j], a[j - 1]);
          /*      int temp;
                temp = a[j];
                a[j] = a[j - 1];
                a[j - 1] = temp;*/
                ArrayUtils.swap(a,j-1,j);

            }

        }
    }


}
