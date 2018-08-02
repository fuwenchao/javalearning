package me.wenchao.javapro.algorithm.sort;

/**
 * @Author wenchaofu
 * @DATE 17:11 2018/7/30
 * @DESC 优化
 */
public class InsertSort2 implements Sort {
    @Override
    public void sort(int[] a) {
        sort(a, 0, a.length - 1);

    }

    public void sort(int[] a, int low, int high) {
        if (a == null || high == 0) {
            return;
        }
        int i,j,temp;
        for (i = 1; i <= high; i++) {
            temp = a[i];
            for(j = i ; j > 0 && a[j-1] > temp; j--) {
                a[j] = a[j - 1];
            }
            a[j] = temp;

        }

    }
}
