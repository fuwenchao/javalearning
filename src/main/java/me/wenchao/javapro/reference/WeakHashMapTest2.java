package me.wenchao.javapro.reference;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

/**
 * @Author wenchaofu
 * @DATE 18:30 2018/5/15
 * @DESC
 */
public class WeakHashMapTest2 {
    public static void main(String[] args) throws Exception {

        List<WeakHashMap<byte[][], byte[][]>> maps = new ArrayList<WeakHashMap<byte[][], byte[][]>>();

        for (int i = 0; i < 1000; i++) {
            WeakHashMap<byte[][], byte[][]> d = new WeakHashMap<byte[][], byte[][]>();
            d.put(new byte[1000][1000], new byte[1000][1000]);
            maps.add(d);
            System.gc();
            System.err.println(i);

            for (int j = 0; j < i; j++) {
                // 触发移除Entry操作
                System.err.println(j+  " size" + maps.get(j).size());
            }
        }
    }


}
