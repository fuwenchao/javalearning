package me.wenchao.javapro.algorithm.sort;

/**
 * @Author wenchaofu
 * @DATE 17:08 2018/7/30
 * @DESC 优化
 */
public class BubbleSorter3 implements Sort {

    @Override
    public void sort(int[] a) {
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
}
