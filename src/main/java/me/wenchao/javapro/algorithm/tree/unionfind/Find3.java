package me.wenchao.javapro.algorithm.tree.unionfind;

/**
 * @Author wenchaofu
 * @DATE 10:44 2018/8/7
 * @DESC 基于size 的优化
 */
public class Find3 implements FindInter {
    private int count;
    private int size[]; // 每个子集的元素个数
    private int[] parent; // 指向父亲节点的

    public Find3(int count) {
        this.count = count;
        parent = new int[count];
        size = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i; // 初始化时自己指向自己
            size[i] = 1;
        }

    }

    public int find(int p) {
        while (p != parent[p]) {
            p = parent[p];
        }
        return p;
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void unionElement(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot != qRoot) {
            if (size[pRoot] > size[qRoot]) {
                qRoot = pRoot;
                size[pRoot] += size[qRoot];
            } else if (size[pRoot] < size[qRoot]) {
                pRoot = qRoot;
                size[qRoot] += size[pRoot];
            }
        }
    }
}
