package me.wenchao.javapro.reference;

/**
 * @Author wenchaofu
 * @DATE 18:09 2018/5/15
 * @DESC
 */

public class ExplicitGarbageRetrieve {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyDate date = new MyDate();
        date = null;
        System.gc();
    }

}