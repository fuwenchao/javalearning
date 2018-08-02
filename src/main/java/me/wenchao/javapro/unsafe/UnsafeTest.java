package me.wenchao.javapro.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author wenchaofu
 * @DATE 9:35 2018/6/26
 * @DESC
 */
public class UnsafeTest {

    private   int a ;

    public static void main(String[] args) throws Exception {

//        Unsafe unsafe1 = Unsafe.getUnsafe();  //抛出异常 安全检查
        Unsafe unsafe = getUnsafeInstance();
        UnsafeTest unsafeTest = new UnsafeTest();
        unsafeTest.a = 100;
        long offset = unsafe.objectFieldOffset(UnsafeTest.class.getDeclaredField("a"));
        System.out.println(unsafe.getInt(unsafeTest, offset));
        System.out.println(unsafe.addressSize());
        System.out.println(System.getProperty("sun.arch.data.model"));


    }

    //绕过安全检查
    public static Unsafe getUnsafeInstance() throws Exception {
        Field unsafeStaticField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeStaticField.setAccessible(true);
        return (Unsafe) unsafeStaticField.get(Unsafe.class);
    }
}
