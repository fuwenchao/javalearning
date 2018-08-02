package me.wenchao.javabasic.strings;

/**
 * @Author wenchaofu
 * @DATE 15:21 2018/5/18
 * @DESC
 */
public class StringIntern {
    public static void main(String[] args) {
        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1); // true

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2); // false

        System.out.println("=============");
        // 第一段代码
        String str11 = new StringBuilder("极1").append("学院").toString();
        System.out.println(str11.intern() == str11);  //true

        String str12 = new StringBuilder("极2").toString();
        System.out.println(str12.intern() == str12);  //false

        // 第二段代码
        String str21 = new StringBuilder("极客").toString();
        System.out.println(str21.intern() == str21); // false

        System.out.println("================");

        String a = "abc";
        System.out.println(a.intern() == a);   // true

        String b = new String("a");
        System.out.println(b.intern() == b);  //false
    }
}
