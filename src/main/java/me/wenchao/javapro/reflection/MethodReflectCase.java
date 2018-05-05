package me.wenchao.javapro.reflection;

import java.lang.reflect.Method;

/**
 * @Author wenchaofu
 * @DATE 18:17 2018/4/30
 * @DESC
 */
public class MethodReflectCase {

    public static void main(String[] args) throws NoSuchMethodException {
        //获取print（int,int)方法
        A a = new A();
        Class<? extends A> aClass = a.getClass();
        try {
            Method m = aClass.getMethod("print", new Class[]{int.class, int.class});
//            aClass.getMethod("print",int.class,int.class)
            //方法如果没有返回值，返回null，如果有返回具体返回值
            Object o = m.invoke(a, new Object[]{10, 20});
        }catch (Exception e){
            System.out.println("......");
            e.printStackTrace();
        }

    }

    static class A{
        public void print(int a , int  b){
            System.out.println(a+b);

        }
        public void print(String a ,String b){
            System.out.println(a+b );

        }
    }
}
