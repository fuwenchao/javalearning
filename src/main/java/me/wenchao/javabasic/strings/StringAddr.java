package me.wenchao.javabasic.strings;

/**
 * @Author wenchaofu
 * @DATE 14:20 2018/5/19
 * @DESC
 */
public class StringAddr {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello1");
        Integer int1 = 10;
        Integer int2 = 10;
        byte b = 127;
        System.out.println(str1 == str2); //false
        System.out.println(b);
        System.out.println(int1 == int2); //true
        Integer int3 = 9999;
        Integer int4 = 9999;
        System.out.println(int3 == int4); //false
        Integer int5 = new Integer(10);
        Integer int6 = new Integer(10);
        System.out.println(int5 == int6); //false

        int int7 = 199999;
        int int8 = 199999;
        System.out.println(int7 == int8); //true

    }


}

