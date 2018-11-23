package me.wenchao.javabasic.basic;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 10:13 2018/8/24
 * @DESC
 */
public class ForScope {

    private static final int THROD = 4;

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(i,"wenchao","wenchao@126.com");
            list.add(user);
        }


//        list = Collections.unmodifiableList(list);


        for (User user : list) {
            System.out.println(user);
        }
/*
        for (int i = 0; i < 3; i++) {
            List<Integer> subList = list.subList(0, list.size() > THROD ? THROD : list.size());
            System.out.println("============");
            for (Integer integer : subList) {
                System.out.println(integer);
            }
            subList.clear();

        }*/


        int i = list.size() % THROD;
        for (int i1 = 0; i1 <= i; i1++) {
            List<User> list2 = list.subList(0, i1 == i ? list.size() :THROD);
            System.out.println("============");
            for (User user : list2) {
                user.setEmail("ddddddd");
                System.out.println(user);
            }
            list2.clear();

        }


        System.out.println(File.separator);


        System.out.println("========909090=======");

        List<Integer> listadd = new ArrayList<>();
        for (int i1 = 0; i1 < 10; i1++) {
            listadd.add(i1);
        }
        System.out.println(listadd.subList(1,2));


        System.out.println(99 /100);

    }
}
