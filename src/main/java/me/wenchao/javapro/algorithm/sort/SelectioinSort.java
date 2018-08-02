package me.wenchao.javapro.algorithm.sort;

import me.wenchao.tool.ArrayUtils;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author wenchaofu
 * @DATE 14:42 2018/7/30
 * @DESC 一趟从待排序的数据元素中选择最小（或最大）的一个元素作为首元素(待排序中最小元素与首元素交换)，
 * 直到所有元素排完为止，简单选择排序是不稳定排序
 */
public class SelectioinSort {

    public static void main(String[] args) throws Exception {
        Integer[] arr = ArrayUtils.generateRandomIntegerArray(10, 1, 28);
        System.out.println("before Selection sort " + Arrays.toString(arr));
/*
        selectionSort(arr,new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return 1;
                } else return -1;
            }
        });
        System.out.println("after Selection sort " + Arrays.toString(arr));

*/

    }

  /*  private static <T> void selectionSort(T[] arr,Comparator<T> comparator) throws Exception {
        selectionsSort(arr , 0, arr.length - 1,comparator);
    }



    private static <T> void selectionsSort(T[] arr, int begin, int end,Comparator<T> comparator) throws Exception {

        if (begin > end || end > arr.length) {
            throw new Exception("wrong arr");
        }



        for (int i = begin; i < end; i++) {
            int minIndex = i;

            for(int j = i+1 ; j <= end ; j++) {
                if (comparator.compare(arr[minIndex],arr[j]) > 0)
                    ArrayUtils.swap(arr, minIndex, j);
            }

        }

    }*/
/*
    // 这个要交换很多次
    private static void selectionsSort(int[] arr, int begin, int end) throws Exception {

        if (begin > end || end > arr.length) {
            throw new Exception("wrong arr");
        }



        for (int i = begin; i < end; i++) {
            int minIndex = i;

            for(int j = i+1 ; j <= end ; j++) {
                if (arr[minIndex] > arr[j])
                    ArrayUtils.swap(arr, minIndex, j);
            }

        }

    }*/

    // 标记出最小最，最后交换
    private static void selectionsSort(int[] arr, int begin, int end) throws Exception {

        if (begin > end || end > arr.length) {
            throw new Exception("wrong arr");
        }


        for (int i = begin; i < end; i++) {
            int minIndex = i;

            for (int j = i + 1; j <= end; j++) {
                if (arr[minIndex] > arr[j])
                    minIndex = j;
            }
            ArrayUtils.swap(arr, minIndex, i);

        }
    }


}
