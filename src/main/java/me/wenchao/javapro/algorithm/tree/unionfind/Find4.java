package me.wenchao.javapro.algorithm.tree.unionfind;

/**
 * @Author wenchaofu
 * @DATE 10:44 2018/8/7
 * @DESC 基于 rank 的优化
 */
public class Find4 implements FindInter {
    private int count;
    private int[] rank; // 每个子集的树的高度
    private int[] parent; // 指向父亲节点的

    public Find4(int count) {
        this.count = count;
        parent = new int[count];
        rank = new int[count];
        for (int i = 0; i < count; i++) {
            parent[i] = i; // 初始化时自己指向自己
            rank[i] = 1;
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
            if (rank[pRoot] > rank[qRoot]) {
                qRoot = pRoot;
            } else if (rank[pRoot] < rank[qRoot]) {
                pRoot = qRoot;
            } else {
                pRoot = qRoot;
                rank[qRoot]++;

            }
        }
    }
}
