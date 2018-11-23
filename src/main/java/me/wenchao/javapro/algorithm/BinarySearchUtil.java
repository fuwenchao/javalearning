package me.wenchao.javapro.algorithm;

import java.util.Comparator;

/**
 * @Author wenchaofu
 * @DATE 16:55 2018/6/5
 * @DESC
 */
public class BinarySearchUtil {


    // 循环查找
    private static <T> int binarySearch(T[] t, T k, Comparator<T> comp) {
        int low = 0;
        int high = t.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int compare = comp.compare(t[mid], k);
            if (compare < 0) {
                low = mid + 1;
            } else if (compare > 0) {
                high = mid + 1;
            } else {
                return mid;
            }

        }
        return -1;

    }

    //递归查找

    private static <T extends Comparable<T>> int binarySearch(T[] t, int low, int high, T key) {
        if (low < high) {
            // 这种方式可以解决 int 相加越界问题
            int mid = low + ((high - low) >>> 2);  // (low + high) / 2 （这样做有bug）
            int compare = key.compareTo(t[mid]);
            if (compare == 0) {
                return mid;
            } else if (compare < 0) {
                return binarySearch(t,low,mid - 1 ,key);
            } else {
                return binarySearch(t, mid + 1, high, key);
            }
        }
        return -1;
    }


    private static <T extends Comparable<T>> int bianrySearch(T[] t, T k) {
        return  binarySearch(t,0,t.length-1,k);
    }

}
