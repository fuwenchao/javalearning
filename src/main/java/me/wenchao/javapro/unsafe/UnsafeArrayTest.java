package me.wenchao.javapro.unsafe;

import sun.misc.Unsafe;

/**
 * @Author wenchaofu
 * @DATE 9:59 2018/6/26
 * @DESC
 */
public class UnsafeArrayTest {

    public static void main(String[] args) throws Exception {
        Unsafe u = UnsafeTool.getUnsafeInstance();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int b = u.arrayBaseOffset(int[].class);
        int s = u.arrayIndexScale(int[].class);
        u.putInt(arr,(long)b+s*9,1);
        for(int i = 0;i<10;i++) {
            int v = u.getInt(arr, (long) b + s * i);
            System.out.print(v + " ");
        }
    }
}
