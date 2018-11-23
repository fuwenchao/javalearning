package me.wenchao.javapro.algorithm.tree.unionfind;

/**
 * @Author wenchaofu
 * @DATE 10:33 2018/8/7
 * @DESC
 */
public class Find1 implements FindInter {
    private int count;
    private int[] unionfind;

    public Find1(int count) {
        this.count = count;
        this.unionfind = new int[count];
        for (int i = 0; i < count; i++) {
            unionfind[i] = i;
        }
    }

    public int size(){
        return count;
    }

    /*
    1 2 3 4 5
    0 0 1 1 1
    说明 1 2 相连 ，3,4，5相连*/
    public int find(int p) {
        return unionfind[p];
    }


    // 将 p 和 q 相连
    public void unionElement(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < count; i++) {
            if (unionfind[i] == pID) {
                unionfind[i] = qID;
            }
        }

    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

}
