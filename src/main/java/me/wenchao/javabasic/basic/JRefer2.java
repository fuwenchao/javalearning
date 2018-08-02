package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 14:58 2018/6/5
 * @DESC
 */
public class JRefer2 {
    private static void change(String str, char[] ch) {
        str = "changed";
        ch[0] = 'C';
    }

    public static void main(String[] args) {
        String str = "123";
        char[] ch = {'a','b','c'};
        change(str,ch);
        System.out.println(str);
        System.out.println(ch);
    }
}
