package me.wenchao.javabasic.exception;

/**
 * @Author wenchaofu
 * @DATE 15:27 2018/5/2
 * @DESC
 */
public class ExceptionHandle  {


    public static void main(String[] args)  {
        int out = 0;
        int a = 10 / 0;

        int i = 999;
        String abc = "abc";
        String xff = "xff";
//        Thread.sleep(1000);
        System.out.println("a i2s ");
        print(a, "abc");
    }

    private static void print(int a, String abc) {
        int a1 = a;
        System.out.println(a1 + abc);
        System.out.println(a1);
        System.out.println(a1);
        System.out.println(a1);
        System.out.println(a1);
    }

    private void pringt(){
    }
}
