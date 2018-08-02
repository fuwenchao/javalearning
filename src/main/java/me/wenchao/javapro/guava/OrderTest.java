package me.wenchao.javapro.guava;

import com.google.common.collect.Ordering;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 16:01 2018/7/19
 * @DESC
 */
public class OrderTest {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(new Integer(5));
        numbers.add(new Integer(2));
        numbers.add(new Integer(15));
        System.out.println(numbers);
        Ordering ordering = Ordering.natural();
        System.out.println(ordering.min(numbers));
        System.out.println(ordering.max(numbers));

        Collections.sort(numbers);
        System.out.println("after sort " + numbers);


        Collections.sort(numbers,ordering.reverse());
        System.out.println(numbers);

        numbers.add(null);
        System.out.println("add null " + numbers);
        // null 排序报错
//        Collections.sort(numbers);

        Collections.sort(numbers, ordering.nullsFirst());
        System.out.println("null first " + numbers);


    }
}
