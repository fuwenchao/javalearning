package me.wenchao.javabasic.basic;

import java.util.Date;

/**
 * @Author wenchaofu
 * @DATE 11:05 2018/7/13
 * @DESC
 */
public class InstanceOfTest {
    public static void main(String[] args) {
        System.out.println(Character.valueOf('A') instanceof Character);
        // 编译不通过，需要有继承或者实现关系
        // System.out.println(new Date() instanceof String);

        System.out.println(null instanceof String);  // false
        System.out.println((String)null instanceof String); // false

//        assert false : "false...";

//        print(null);


        System.out.println(1.00 - 0.60);
    }

    private static void print(String string) {
        assert string != null : "参数不能为空";
    }
}
