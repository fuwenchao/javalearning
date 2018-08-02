package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 16:28 2018/6/7
 * @DESC
 */
class Person{
    private int a;
    long l = 123;
    public int changeA(int a){
        this.a = a;
        return a;
    }
}
public class NullExp extends Person{
    int i;  //如果是Integer 类项。抛出空指针异常
    int y;
    int x;
    String str = "234";

    NullExp(int y) {
        x = y + i;
        System.out.println(x);
        System.out.println(str.length());
        switch (str) {
            case "123":
                System.out.println(123);
                break;
            case "234":
                System.out.println("234----");
                break;
            default:
                System.out.println("unkonw");
        }
    }

    public static void main(String[]args) {
        NullExp nullExp = new NullExp(new Integer(4));
        int i;
        i = nullExp.x;
        System.out.println("i is " + i);


    }
}
