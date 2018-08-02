package me.wenchao.javapro.generic;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @Author wenchaofu
 * @DATE 9:55 2018/7/11
 * @DESC
 */

class Father<T> {

}

class Son extends Father<String> {

}
public class SuperClass {
    public static void main(String[] args) {
        Class<? super Son> superclass = Son.class.getSuperclass();
        System.out.println(superclass);
        Type genericSuperclass = Son.class.getGenericSuperclass();
        System.out.println(genericSuperclass);
        if (genericSuperclass instanceof ParameterizedType) {
            ParameterizedType type = (ParameterizedType)genericSuperclass;
            Type[] actualTypeArguments = type.getActualTypeArguments();
            if (actualTypeArguments != null && actualTypeArguments.length>0) {
                Type type0 = actualTypeArguments[0];

                System.out.println("======");
                System.out.println(type0);
                System.out.println((Class)type0);
                System.out.println((Class)type0 == String.class);

            }

        }
    }
}
