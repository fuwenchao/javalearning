package me.wenchao.javapro.reflection;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author wenchaofu
 * @DATE 16:42 2018/7/10
 * @DESC
 */

class Parent {
    public void publicMethod(){
        System.out.println("this is parent public method");
    }
    private void privateMethod(){
        System.out.println("this is parent private method");

    }
}
public class Declared extends Parent{
    public void sonPubilcMethod(){

    }
    private void sonPrivateMethod(){

    }

    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        System.out.println("getMethods() ... ");
        System.out.println("===================");
        Method[] methods = Declared.class.getMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            System.out.println(method.getName());
        }
        System.out.println("====================");
        System.out.println("getDeclaredMethods() ...");
        System.out.println("======================");
        Method[] declaredMethods = Declared.class.getDeclaredMethods();
        AccessibleObject.setAccessible(declaredMethods,true);
        for (Method declaredMethod : declaredMethods) {
            declaredMethod.setAccessible(true);
            System.out.println(declaredMethod.getName());
        }
        System.out.println("===============");
        System.out.println("father");
        System.out.println("================");

        Method[] declaredMethods1 = Declared.class.getSuperclass().getDeclaredMethods();
        for (Method method : declaredMethods1) {
            System.out.println(method.getName());
        }

        System.out.println("==========================");
        System.out.println("begin to invoke method");
        System.out.println("==========================");

        Method publicMethod = Declared.class.getMethod("publicMethod");
        System.out.println("accessable is " + publicMethod.isAccessible());
        publicMethod.invoke(Declared.class.newInstance());


        System.out.println("===============");

        String[] strings = (String[]) Array.newInstance(String.class, 8);
        strings[0] = "wenchaofu";
        for (String string : strings) {
            System.out.println(string);
        }

    }

}
