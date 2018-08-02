package me.wenchao.javapro.unsafe;

/**
 * @Author wenchaofu
 * @DATE 10:05 2018/6/26
 * @DESC
 */
public class Test {
    public int intfield;
    public static int staticIntField;
    public static int[] arr;

    private Test() {
        System.out.println("constructor called");
    }

}
