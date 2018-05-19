package me.wenchao.javapro.generic;

/**
 * @Author wenchaofu
 * @DATE 17:50 2018/5/9
 * @DESC
 */

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class ParamatrizedTypeTest {
    public static void main(String[] args) throws NoSuchMethodException {
        new Sub();
    }
}

class Parent {

}

class Child extends Parent {

}

class UpperGeneric {
    static class Generic<T, R> {
        T t;
        R r;

        protected Generic(T t, R r) {
            this.t = t;
            this.r = r;
        }

        void foo() {
            System.err.println(t + " " + r);
        }
    }
}

class Sub extends UpperGeneric.Generic<Child, Integer> {

    protected Sub() {
        super(new Child(), 1);
        Class clazz = getClass().getSuperclass();
        System.err.println("super clazz:" + clazz);

        Type type = getClass().getGenericSuperclass();
        System.err.println("generic super class type:" + type);

        Type trueType = ((ParameterizedType) type).getActualTypeArguments()[0];
        System.err.println("type 0:" + trueType);
        trueType = ((ParameterizedType) type).getActualTypeArguments()[1];
        System.err.println("type 1:" + trueType);

        trueType = ((ParameterizedType) type).getRawType();
        System.err.println("raw type:" + trueType);

        trueType = ((ParameterizedType) type).getOwnerType();
        System.err.println("owner type:" + trueType);
    }
}
