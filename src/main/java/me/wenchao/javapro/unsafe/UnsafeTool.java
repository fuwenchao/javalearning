package me.wenchao.javapro.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author wenchaofu
 * @DATE 9:59 2018/6/26
 * @DESC
 */
public class UnsafeTool {
    //绕过安全检查
    public static Unsafe getUnsafeInstance() throws Exception {
        Field unsafeStaticField = Unsafe.class.getDeclaredField("theUnsafe");
        unsafeStaticField.setAccessible(true);
        return (Unsafe) unsafeStaticField.get(Unsafe.class);
    }
}
