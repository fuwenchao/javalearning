package me.wenchao.javapro.algorithm.tree.heap;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 9:44 2018/8/3
 * @DESC 特点：二叉大顶堆，每个节点不大于其父节点。完全二叉树
 * <p>
 * 由于是完全二叉树，所以可以用数组存储，数组下标从0开始
 * <p>
 * <p>
 * i 从 1 开始
 * parent  = i / 2
 * left child = 2 * i
 * right child = 2 * i + 1
 * <p>
 * 从0 开始
 * parent  = (i-1) / 2
 * left child = 2 * i + 1
 * right child = 2 * i + 2
 */
public class MaxHeap<T extends Comparable<T>> implements HeapInterface<T> {
//    private T[] data;
//    private int count;


    private List<T> heap;

    private List<T> originList;


    public MaxHeap(int capacity) {
//        data = (T[]) new Object[capacity];
    }

    @Override
    public void display() {
        for (int i = 0; i < heap.size(); i++) {
            System.out.print(heap.get(i) + " ");
        }
        System.out.println();

    }

    @Override
    public void initOriginList(List<T> originList) {
        this.originList = originList;
    }

    public MaxHeap() {
        this.heap = new ArrayList<>();
    }

    public MaxHeap(List<T> list) {
        this.heap = list;
        makeHeap();
    }


    private void shiftUp(int k) {
        // 大于父节点
        while (k > 0 && heap.get(k / 2).compareTo(heap.get(k)) < 0) {
            Collections.swap(heap, k, k / 2);
            k /= 2;
        }
    }

    public void insert(T data) {
        int size = heap.size();
        heap.add(data);
        shiftUp(size);
    }

    // 会在队列中删除该最大值
    public T extractMax() {
        T maxData = heap.get(0);
        Collections.swap(heap, 0, heap.size() - 1);
        heap.remove(heap.size() - 1);
        shiftDown(0);
        return maxData;
    }

    private void shiftDown(int i) {
/*        // 有左子树
        int j;
        while (heap.size() - 1 > 2 * i) {
            j = 2 * i + 1; // 左孩子
            if (heap.size() - 1  >= j + 1 && heap.get(j + 1).compareTo(heap.get(j)) > 0) { // 有右孩子且右孩子更大
                j++;
            }
            if (heap.get(i).compareTo(heap.get(j)) > 0) {
                break;
            }
            Collections.swap(heap, i, j);

            i = j;

        }*/
        shiftDown(heap.size(), i);
    }

    // 前 n 个元素中的 i 个元素进行 shiftDown 操作
    public void shiftDown(int n, int i) {
        // 有左子树
        int j;
        while (n >= 2 * i + 1 + 1 ) {
            j = 2 * i + 1; // 左孩子
            if (n - 1 >= j + 1 && heap.get(j + 1).compareTo(heap.get(j)) > 0) { // 有右孩子且右孩子更大
                j++;
            }
            if (heap.get(i).compareTo(heap.get(j)) > 0) {
                break;
            }
            Collections.swap(heap, i, j);

            i = j;

        }
    }

    @Override
    public void makeHeap() {
        // Heapify
        for (int i = this.heap.size() / 2; i >= 0; i--) {
            shiftDown(i);
        }
    }

    @Override
    public void popHeap(int first, int last) {

    }

    @Override
    public void pushHeap(int first, int last) {

    }

    @Override
    public List<T> getHeap() {
        return this.heap;
    }

    // 原地堆排序 效果最好
    public <T extends Comparable<T>>  void sort() throws IOException, ClassNotFoundException {


        List<T> forSortHeap = (List<T>) deepCopy(this.heap);
        int size = forSortHeap.size();

        for (int i = size - 1; i > 0; i--) {
            Collections.swap(forSortHeap,0,i);
            this.shiftDown(i,0);

        }

        System.out.println("=============sss");
        for (int i = 0; i < forSortHeap.size(); i++) {
            System.out.println(forSortHeap.get(i));
        }
    }

    //关键代码 运行序列化和反序列化  进行深度拷贝
    public static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }

}
