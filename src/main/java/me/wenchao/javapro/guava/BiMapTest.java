package me.wenchao.javapro.guava;

import com.google.common.collect.HashBiMap;

/**
 * @Author wenchaofu
 * @DATE 16:39 2018/7/19
 * @DESC 值是唯一的，如果键重复put，默认是update.inverse() 反转键值对
 */

public class BiMapTest {
    public static void main(String[] args) {
        HashBiMap<Integer, String> biMap = HashBiMap.create();
        biMap.put(new Integer(11), "wenchaofu1");
        biMap.put(new Integer(11), "wenchaofu");
        System.out.println(biMap.get(new Integer(11)));
        System.out.println(biMap.inverse());
    }
}
