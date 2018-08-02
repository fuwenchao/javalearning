package me.wenchao.javapro.unsafe;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @Author wenchaofu
 * @DATE 10:26 2018/6/26
 * @DESC
 */
public class UnsafeString {
    public static void main(String[] args) throws Exception {
        String s = "aabc"; //保存s的引用
        s.intern(); //此时s1==s，地址相同
        String s1 = "aabc";
        Unsafe u = UnsafeTool.getUnsafeInstance();
        // 获取s的实例变量value
        Field valueInString = String.class.getDeclaredField("value");
        // 获取value的变量偏移值
        long offset = u.objectFieldOffset(valueInString);
        // value本身是一个char[],要修改它元素的值，仍要获取baseOffset和indexScale
        long base = u.arrayBaseOffset(char[].class);
        long scale = u.arrayIndexScale(char[].class);
        System.out.println("scale is " + scale);
        // 获取value
        char[] values = (char[]) u.getObject(s, offset);
        // 为value赋值
        u.putChar(values, base + scale, 'c');
        System.out.println("s:" + s + " s1:" + s1);
        // 将s的值改为abc
            s = "aabc";
        String s2 = "aabc";
        String s3 = "aabc";
        System.out.println("s:" + s + " s1:" + s1 + " s2: " + s2 + " s3: " + s3);
    }
}
