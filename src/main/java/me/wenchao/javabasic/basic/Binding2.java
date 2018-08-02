package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 11:32 2018/5/28
 * @DESC
 * @see https://www.cnblogs.com/iamzhoug37/p/5474488.html
 */
public class Binding2
{
    public static void main(String[] args)
    {
        Base b = new Base();
        Derived d = new Derived();
        Binding2 binding2 = new Binding2();
        whichFoo(b,b);
        whichFoo(b,d);
        whichFoo(d,b);
        whichFoo(d,d);
    }
    public static  void whichFoo(Base arg1, Base arg2){
        arg1.foo(arg2);
    }
}

class Base{
    public void foo(Base x){
        System.out.println("Base.Base");
    }

    public void foo(Derived x){
        System.out.println("Base.Derived");
    }
}



class Derived extends Base{
    public void foo(Base x){
        System.out.println("Derived.Base");
    }

    public void foo(Derived x){
        System.out.println("Derived.Derived");
    }
}