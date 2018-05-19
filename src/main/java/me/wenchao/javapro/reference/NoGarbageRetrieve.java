package me.wenchao.javapro.reference;

/**
 * @Author wenchaofu
 * @DATE 18:08 2018/5/15
 * @DESC
 */
public class NoGarbageRetrieve {

    public static void main(String[] args) {
        MyDate date = new MyDate();
        date = null;
    }
}