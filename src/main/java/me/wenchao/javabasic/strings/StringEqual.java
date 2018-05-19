package me.wenchao.javabasic.strings;

/**
 * @Author wenchaofu
 * @DATE 14:02 2018/5/19
 * @DESC
 */
public class StringEqual {

    public static final String s1="abc";
    public static final String s2="def";


    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "abc";
        System.out.println(str1 == str2);
        String str3 = "ab" + "c";
        System.out.println(str1 == str3);
        String str5 = "ab";
        String str6 = str5 + "c";  // 地址不一样了，内容一样
        System.out.println(str1 == str6);
        System.out.println(str1.equals(str6));

        String str7 = new String("abc");

        String s3=s1+s2;
        String s4="abcdef";
        System.out.println(s3==s4);


        String s10=new String("abc");
        String s20=s1.intern();
        String s30="abc";
        System.out.println(s20==s30); //true
    }
}
