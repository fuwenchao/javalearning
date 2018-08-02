package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 15:34 2018/5/24
 * @DESC
 */
public class SwitchTest {
    static int j;

    public static void main(String[] args) {
        int i = 1;
        System.out.println(j);

        switch (i) {
            case 1:
            case 2:
                System.out.println(2);
            case 10:
                System.out.println(10);break;
            case 11:
                System.out.println(11);
                default:
                    System.out.println("defalut");
        }
    }
}
