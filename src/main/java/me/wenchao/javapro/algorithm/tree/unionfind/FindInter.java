package me.wenchao.javapro.algorithm.tree.unionfind;

/**
 * @Author wenchaofu
 * @DATE 10:55 2018/8/7
 * @DESC
 */
public interface FindInter {
    boolean isConnected(int p, int q);

    void unionElement(int p, int q);

    int find(int p);
}
