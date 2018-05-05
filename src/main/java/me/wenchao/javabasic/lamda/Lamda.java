package javabasic;

import java.util.Arrays;
import java.util.List;

public class Lamda {
    public static void main(String[] args) {
        System.out.println("this is in main");
        new Thread(
            new Runnable(){


                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("this is in runnable");

                }
            }
        ).start();



        // lamda style
        new Thread(
                () -> System.out.println("this is lamda test")
        ).start();


        List<String> listStr = Arrays.asList("java","c++","c#","python");
        for (String s : listStr) {
            System.out.println("this is in for " + s);
        }

        listStr.forEach(str -> System.out.println("this is in foreach " + str));
        System.out.println("*******************");

        listStr.forEach(System.out::println);
    }
}
