package me.wenchao.javabasic.strings;

/**
 * @Author wenchaofu
 * @DATE 20:37 2018/5/20
 * @DESC
 */
public class TestA {
    public static void main(String[] args) {
        A a1=new  A();
        A a2=new A();
        System.out.println(a1.tempString==a2.tempString);
        System.out.println(a1.tempStringArray==a2.tempStringArray);//看这里
        System.out.println("#####################");//看这里
        System.out.println(a1.tempStringArray[0]==a2.tempStringArray[0]);
        System.out.println(a1.tempStringArray[0]=="Fire");
        System.out.println("#####################");
        System.out.println(a1.charArray==a2.charArray);
        System.out.println(a1.charx==a2.charx);
    }
}