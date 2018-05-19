package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 15:21 2018/5/15
 * @DESC
 */
public class finallyTest2 {
    public static void main(String[] args) {
        System.out.println(test().numnum);
    }

    public static Num test() {
        Num num = new Num();
        try {
            System.out.println("try");
            return num;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("finally");
            num.numnum = 200;
        }
        return num;
    }
}

class Num {
    public int numnum = 10;



}



