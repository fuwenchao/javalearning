package me.wenchao.javapro.algorithm.tree.unionfind;

import java.util.Random;

/**
 * @Author wenchaofu
 * @DATE 10:54 2018/8/7
 * @DESC
 */
public class MainApp {

    private static final int n = 1000000;

    public static void main(String[] args) {

        FindInter uf = new Find5(n);
        FindInter uf1 = new Find1(n);
        FindInter uf2 = new Find3(n);
        FindInter uf3 = new Find4(n);
        testFind(uf, n);
        testFind(uf1, n);
        testFind(uf2, n);
        testFind(uf3, n);
    }

    private static void testFind(FindInter uf, int n) {
        long startTime = System.currentTimeMillis();
        Random rand = new Random();
        for( int i = 0 ; i < n ; i ++ ){
            int a = rand.nextInt(n);
            int b = rand.nextInt(n);
            uf.unionElement(a,b);
        }
        for(int i = 0 ; i < n ; i ++ ){
            int a = rand.nextInt(n);
            int b = rand.nextInt(n);
            uf.isConnected(a,b);
        }
        System.out.println( uf.getClass().getSimpleName() + " use time is " + (System.currentTimeMillis() - startTime) / 1000.0 + " s ");

    }
}
