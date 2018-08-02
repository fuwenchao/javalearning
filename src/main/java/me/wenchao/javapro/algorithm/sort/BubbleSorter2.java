package me.wenchao.javapro.algorithm.sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author wenchaofu
 * @DATE 16:05 2018/6/5
 * @DESC
 */
interface Sorter {

    /**
     * 排序
     * @param list 待排序的数组
     */
    public <T extends Comparable<T>> void sort(T[] list);

    /**
     * 排序
     * @param list 待排序的数组
     * @param comp 比较两个对象的比较器
     */
    public <T> void sort(T[] list, Comparator<T> comp);
}
public class BubbleSorter2 implements Sorter {

    @Override
    public <T extends Comparable<T>>  void sort(T[] list) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            swapped = false;
            for (int j = 0; j < len - i; ++j) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }

    @Override
    public <T> void sort(T[] list, Comparator<T> comp) {
        boolean swapped = true;
        for (int i = 1, len = list.length; i < len && swapped; ++i) {
            swapped = false;
            for (int j = 0; j < len - i; ++j) {
                if (comp.compare(list[j], list[j + 1]) > 0) {
                    T temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    swapped = true;
                }
            }
        }
    }


    public static void main(String[] args) {
        BubbleSorter2 bubbleSorter2 = new BubbleSorter2();

        String[] str = {"a","c","v","b"};

        bubbleSorter2.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return 0;
            }
        });
        System.out.println(Arrays.toString(str));
    }
}
