package me.wenchao.javapro.concurrency.immutable;

import com.google.common.collect.Maps;
import me.wenchao.annotation.NotThreadSafe;

import java.util.Map;

/**
 * @Author wenchaofu
 * @DATE 15:32 2018/6/13
 * @DESC
 */
@NotThreadSafe
public class FinalTest {
    private final static int a = 0;
    private final static String b  =  "a";
    private final static Map<Integer,Integer> map = Maps.newHashMap();
    static{
        map.put(1, 3);
        map.put(2, 4);
        map.put(3, 6);
    }

    public static void main(String[] args) {
        map.put(1, 999);
        System.out.println(map.get(1));
    }

}
