package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 11:54 2018/5/28
 * @DESC
 */
public class Binding3 {
    static void print(){
        System.out.println("father");

    }

    public static void main(String[] args) {
        Binding3 binding3= new Son2();
        binding3.print();
    }

}
class Son2 extends Binding3{
    public static void print(){
        System.out.println("son");
    }
}
