package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 10:23 2018/5/28
 * @DESC
 */

class Father {
    private String str="123a";
    public final String str1="1234a";
    public void print(){
        System.out.println("father");
    }

}
class Son extends Father {
    public String str="123b";
    public final String str1="1234b";
    public void print(){
        System.out.println("son");
    }

    public void print1(){
        System.out.println("son1");
    }

}
public class OverrideTest {
    static Father father = new Son();

    public static void main(String[] args) {
        System.out.println(father.str1);
        father.print();
    }
}
