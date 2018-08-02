package me.wenchao.javabasic.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 14:47 2018/7/9
 * @DESC
 */
public class Union {
    public static void main(String[] args) {

        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();
        list1.add("A");
        list1.add("B");

        list2.add("B");
        list2.add("C");

        // 并集 有重复
        list1.addAll(list2);

        // 并集 无重复

        list1.removeAll(list2);
        list1.addAll(list2);


        //  交集
//        list1.retainAll(list2);

        // 差集 我有你没有
//        list1.removeAll(list2);


        for (String s : list1) {
            System.out.println(s);

        }


    }
}
