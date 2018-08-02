package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 11:20 2018/5/28
 * @DESC
 */
public class Binding
{
    public static void main(String[] args)
    {
        A a = new A() ;
        A b = new B() ;

        a.a() ;
        b.a() ;

        System.out.println(a.a);
        System.out.println(b.a);
    }
}

class A
{
    int a = 22 ;
    public static void a(){
        System.out.println("a");
    }
}

class B extends A{
    int  a = 33 ;
    public static void a()
    {
        System.out.println("b");
    }
}