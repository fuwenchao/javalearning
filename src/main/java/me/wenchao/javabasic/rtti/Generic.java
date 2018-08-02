package me.wenchao.javabasic.rtti;

/**
 * @Author wenchaofu
 * @DATE 17:55 2018/5/29
 * @DESC
 */
public class Generic {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Class<? extends Number> a = int.class;
        System.out.println(a);
    }
}
