package me.wenchao.javapro.algorithm.tree.heap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 14:34 2018/8/3
 * @DESC
 */
public class MainApp {
    public static void main(String[] args) {
        MaxHeap<Integer> intMaxHeap = new MaxHeap<>();
        intMaxHeap.insert(1);
        intMaxHeap.insert(10);
        intMaxHeap.insert(100);
        intMaxHeap.insert(22);
        intMaxHeap.insert(77);
        intMaxHeap.insert(55);

        System.out.println(intMaxHeap.getHeap().size());
        intMaxHeap.display();
        Integer[] a = new Integer[intMaxHeap.getHeap().size()];
        heapSort(intMaxHeap,a);

/*        Integer maxValue = intMaxHeap.extractMax();
        intMaxHeap.display();

        System.out.println("sort 1 ====");*/


        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 12; i++) {
            list.add(i);
        }
        MaxHeap<Integer> intMaxHeap2 = new MaxHeap<>(list);
        System.out.println("display 2 ....");
        intMaxHeap2.display();
        heapSort2(Arrays.asList(1,2,3,4,5,6,7333,21,2,21124,5,66));



    }

    private static <T extends Comparable<T>>  void heapSort(MaxHeap<T> maxHeap,T[] arr) {
        System.out.println("=====================");
        int size = maxHeap.getHeap().size();
//        T[] list = (T[])new Object[size];
        for (int i = size - 1;i >= 0 ; i--) {
            arr[i] = maxHeap.extractMax();
        }
        System.out.println();
        System.out.println("=========================");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " >> ");
        }
    }


    // 原地堆排序，效果最好
    private static <T extends Comparable<T>>  void heapSort2(List<T> list) {
        MaxHeap<T> maxHeap = new MaxHeap(list);
        int size = maxHeap.getHeap().size();
        for (int i = size - 1; i > 0; i--) {
            Collections.swap(list,0,i);
            maxHeap.shiftDown(i,0);

        }

        System.out.println("=============sss");
        maxHeap.display();





    }


    }
