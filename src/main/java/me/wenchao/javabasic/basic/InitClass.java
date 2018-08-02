package me.wenchao.javabasic.basic;

import java.util.Random;

/**
 * @Author wenchaofu
 * @DATE 10:56 2018/5/28
 * @DESC
 */
class Test{
    static{
        System.out.println("this is test static");
    }
//    public final static String str = "this is Test string ";
    static Random random = new Random();
    public final static int int1 = random.nextInt();

}
public class InitClass {
    public static void main(String[] args) {
        System.out.println(Test.int1);
    }
}
