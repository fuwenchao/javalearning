package me.wenchao.javapro.concurrency.immutable;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import me.wenchao.annotation.ThreadSafe;

import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 15:43 2018/6/13
 * @DESC
 */
@ThreadSafe
public class ImmutableTest {
    private final static ImmutableList list = ImmutableList.of(1, 2, 3);
//    private final static List<Integer> list = ImmutableList.of(1, 2, 3);
    private final static ImmutableSet set = ImmutableSet.copyOf(list);

//    private final static ImmutableMap map = ImmutableMap.of(1,2,3,4,5,6);
    private final static ImmutableMap map = ImmutableMap.<Integer,Integer>builder()
            .put(1, 2)
            .put(3,4)
            .build();
    public static void main(String[] args) {
//        list.add(4);
//        set.add(4);
        System.out.println(map.get(3));
    }
}
