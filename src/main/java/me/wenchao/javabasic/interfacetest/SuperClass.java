package me.wenchao.javabasic.interfacetest;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @Author wenchaofu
 * @DATE 15:08 2018/5/31
 * @DESC
 */
class Father {

}

public class SuperClass {
    public static void main(String[] args) {
        System.out.println(SuperClass.class.getSuperclass().getSimpleName());
        System.out.println(Father.class.isAssignableFrom(SuperClass.class));
        Set<String> set = new LinkedHashSet<String>(2, 2);
        set.add("this is a test");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println("------------");
            System.out.println(iterator.next());
        }
    }

}

