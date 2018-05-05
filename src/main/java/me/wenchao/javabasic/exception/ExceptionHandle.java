package me.wenchao.javabasic.exception;

/**
 * @Author wenchaofu
 * @DATE 15:27 2018/5/2
 * @DESC
 */
public class ExceptionHandle  {
    public static void main(String[] args)  {
        int a = 0;
        a = 10 / 0;
//        Thread.sleep(1000);
        System.out.println("a is ");
        System.out.println(a);
    }
}
