package me.wenchao.javapro.reflection;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 18:33 2018/4/30
 * @DESC
 */
public class GenericReflact {
    public static void main(String[] args) {
        List list1 = new ArrayList<>();
        List list2 = new ArrayList<String>();
        Class c1 = list1.getClass();
        Class c2 = list2.getClass();
        System.out.println(c1 == c2);
        try{
            //绕过了编译就绕过了泛型
            Method add = c2.getMethod("add", Object.class);
            Object invoke = add.invoke(list2, 10);

        }catch (Exception e){

        }
        System.out.println(list2.size());
        //这里不能用for String 去遍历，否则抛出异常 String o : list2
        for (Object o : list2) {
            System.out.println("for 遍历" + o);
        }
        System.out.println(list2);
    }
}
