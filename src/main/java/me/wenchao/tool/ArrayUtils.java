package me.wenchao.tool;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * @Author wenchaofu
 * @DATE 14:35 2018/7/10
 * @DESC
 */
public class ArrayUtils {
    public static <T> List<T> asList(T... t) {
        List<T> list = new ArrayList<>();
        Collections.addAll(list, t);
        return list;

    }


  /*  public static <T> T[] toArray(List<T> list) {
        T[] t = (T[]) new Object[list.size()];

        for (int i = 0; i < list.size(); i++) {
            t[i] = list.get(i);
        }
        return t;

    }*/


    public static <T> T[] toArray(List<T> list,Class<T> tClass) {
        T[] t = (T[]) Array.newInstance(tClass, list.size());


        for (int i = 0; i < list.size(); i++) {
            t[i] = list.get(i);
        }
        return t;


    }


    public static int[] generateRandomArray(int n, int rangeL, int rangeR) throws Exception {

        if (rangeL > rangeR){
            throw new Exception("wrong numbers");
        }
        int[] arr = new int[n];

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }

        return arr;

    }


    public static Integer[] generateRandomIntegerArray(int n, int rangeL, int rangeR) throws Exception {

        if (rangeL > rangeR){
            throw new Exception("wrong numbers");
        }
        Integer[] arr = new Integer[n];

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }

        return arr;

    }

    public static int[] generateRandomNearlyOrderedArray(int n, int swapTimes) throws Exception {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] =i;
        }

        Random random = new Random();

        for (int i = 0; i < swapTimes; i++) {
            swap(arr,random.nextInt(n),random.nextInt(n));
        }
        return arr;

    }


    public static <T> T[] generateRandomTArray(int n, int rangeL, int rangeR,Class<T> type, T t) throws Exception {

        if (rangeL > rangeR){
            throw new Exception("wrong numbers");
        }

        // 泛型数组的两种方式
        // 1
        T[] arr = (T[])new Object[n];
        // 2
        int sz = 100;
        T[] arr2 = (T[])Array.newInstance(type,sz);

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = t;
        }

        return arr;

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

/*    public  static <T> T[] generateRandomTArray(int n, int rangeL, int rangeR) {
        T[] arr;

        Random random = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = random.nextInt(rangeR - rangeL + 1) + rangeL;
        }

        return T;

    }*/
}
