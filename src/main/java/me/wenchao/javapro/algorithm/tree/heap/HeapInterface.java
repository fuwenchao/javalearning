package me.wenchao.javapro.algorithm.tree.heap;

import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 10:01 2018/8/3
 * @DESC 采用动态数组来做存储
 */
public interface HeapInterface<T extends Comparable<T>> {

    void display();

    void initOriginList(List<T> originList);

    void makeHeap();

    void popHeap(int first, int last);

    void pushHeap(int first, int last);

    List<T> getHeap();
}
