package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 15:21 2018/5/15
 * @DESC
 */
public class finallyTest {
    public static void main(String[] args) {
        System.out.println(test());
    }
    public static int test() {
        int num = 100;
        try{
            System.out.println("try");
            return num;
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            num = 200;
            return num;
        }
    }
}



