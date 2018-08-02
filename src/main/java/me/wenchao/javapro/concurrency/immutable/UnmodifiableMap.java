package me.wenchao.javapro.concurrency.immutable;

import com.google.common.collect.Maps;
import me.wenchao.annotation.ThreadSafe;

import java.util.Collections;
import java.util.Map;

/**
 * @Author wenchaofu
 * @DATE 15:32 2018/6/13
 * @DESC
 */
@ThreadSafe
public class UnmodifiableMap {
    private final static int a = 0;
    private final static String b  =  "a";
    private static Map<Integer,Integer> map = Maps.newHashMap();
    static{
        map.put(1, 3);
        map.put(2, 4);
        map.put(3, 6);
        map = Collections.unmodifiableMap(map);
    }

    public static void main(String[] args) {
        map.put(1, 999); // 该操作不允许
        System.out.println(map.get(1));
    }

}
