package me.wenchao.javapro.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author wenchaofu
 * @DATE 10:06 2018/6/26
 * @DESC
 */
public class UnsafeUseTest {
    public static void main(String[] args) throws Exception {
        Unsafe unsafe = UnsafeTool.getUnsafeInstance();
        Test t = (Test)unsafe.allocateInstance(Test.class);

        // 修改实例变量
        long intField = unsafe.objectFieldOffset(Test.class.getDeclaredField("intfield"));
        unsafe.putInt(t,intField,2);
        System.out.println("----" + t.intfield);

        System.out.println("=================");

        //  修改static变量

        Field staticFiled = Test.class.getDeclaredField("staticIntField");
        Object o = unsafe.staticFieldBase(staticFiled);
        System.out.println(o == Test.class);
        long b = unsafe.staticFieldOffset(staticFiled);
        unsafe.putInt(o,b,10);
        System.out.println("static Filed is " + Test.staticIntField);
        System.out.println(unsafe.getInt(Test.class,b));

    }
}
