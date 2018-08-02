package me.wenchao.javapro.algorithm.sort.call;

import me.wenchao.javapro.algorithm.sort.*;
import me.wenchao.javapro.algorithm.sort.call.TimeHandler;
import me.wenchao.tool.ArrayUtils;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * @Author wenchaofu
 * @DATE 16:29 2018/7/30
 * @DESC
 */
public class MainApp {
    public static void main(String[] args) throws  Exception {

        int[] arr = ArrayUtils.generateRandomArray(10000, 1, 10);
//        int[] arr = ArrayUtils.generateRandomNearlyOrderedArray(10000, 100);
//

        biz(new BubbleSorter(),arr.clone());
        System.out.println("============");
        biz(new BubbleSorter3(),arr.clone());
        System.out.println("============");
        biz(new InsertSort(),arr.clone());
        System.out.println("=============");
        biz(new InsertSort2(),arr.clone());
        System.out.println("================");
        biz(new MergeSort(), arr.clone());
        System.out.println("================");
        biz(new MergeSort2(), arr.clone());
        System.out.println("================");
        biz(new MergeSort3(), arr.clone());
        System.out.println("================");
        biz(new MergeSortBU(), arr.clone());
        System.out.println("================");
        biz(new QuickSort(), arr.clone());
        System.out.println("================");
        biz(new QuickSort2(), arr.clone());
        System.out.println("================");
        biz(new QuickSort3(), arr.clone());
        System.out.println("================");
        biz(new QuickSort4(), arr.clone());
        System.out.println("================");
        biz(new QuickSort5(), arr.clone());

    }

    private static void biz(Sort sort, int[] arr) throws Exception {

        InvocationHandler handler = new TimeHandler(sort);
        Class<? extends Sort> clz = sort.getClass();
        Sort sortProxy = (Sort) Proxy.newProxyInstance(clz.getClassLoader(), clz.getInterfaces(), handler);
        System.out.println("before sort " + Arrays.toString(arr));
        sortProxy.sort(arr);
        System.out.println("after sort  " + Arrays.toString(arr));

    }

}
