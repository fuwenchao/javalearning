package me.wenchao.javabasic.strings;

/**
 * @Author wenchaofu
 * @DATE 16:34 2018/5/20
 * @DESC
 */
public class StringIntern2 {
    public static void main(String[] args) {
        String s1 = new String("1");
        s1.intern();
        String s2 = "1";
        System.out.println(s1 == s2);

        String s3 = new String("1") + new String("2");
        String s5 = s3.intern();
        String s4 = "11";
        System.out.println(s5 ==s4);
    }
}
