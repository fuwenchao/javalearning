package me.wenchao.javapro.algorithm.sort;

import me.wenchao.tool.ArrayUtils;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author wenchaofu
 * @DATE 16:20 2018/6/11
 * @DESC 快速排序，冒泡排序的升级 分而治之的思想
 * 基本思想 ： 选择一个基准元素，通常是第一个或者最后一个，通过一趟扫描，将数组分为两部分，大的在基准的右边，小的在左边
 *  * 优化为平衡树,但是如果数组中有大量重复元素，还是会退化为O(n^2)
 *  优化：双向
 *
 *  优化：三路快速排序，在解决大量重复数组时效率最好
 */
public class QuickSort5 implements Sort{
    public static void main(String[] args) {
        int[] a = {12, 3, 212, 121, 12, 32, 4,2,3,4,5,6,7,8,9,90,99};
        new QuickSort5().sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Override
    public void sort(int[] a) {
        quickSort("all",a, 0, a.length - 1);
    }

    private static void quickSort(String str,int[] a, int low, int high) {

        System.out.println(str + " low is " + low + " high is " + high);

        if(high <= low) return;

        Random random = new Random();
        ArrayUtils.swap(a,low,random.nextInt(high-low + 1) + low);
        int value = a[low];

        int lt = low, gt = high + 1;
        int i = low + 1;


        while (i < gt) {

            if (a[i] > value) {
                ArrayUtils.swap(a,i,gt-1);
                gt--;

            } else if (a[i] < value) {
                ArrayUtils.swap(a,i,lt+1);
                lt++;
                i++;

            } else {
                i++;
            }
        }
        ArrayUtils.swap(a,low,lt);

        quickSort("low",a,low,lt - 1);
        quickSort("high",a,gt,high);

    }

}
