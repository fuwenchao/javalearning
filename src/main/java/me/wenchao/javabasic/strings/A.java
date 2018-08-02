package me.wenchao.javabasic.strings;

/**
 * @Author wenchaofu
 * @DATE 20:37 2018/5/20
 * @DESC
 */
public class A {
    public String tempString="world";
    public final String tempStringArray[]={"Fire","Lang"};
    public final char[] charArray={'h','e','l','l','o'};
    public Character charx='l';

    public char[] getCharArray() {
        return charArray;
    }
    public String getTempString() {
        return tempString;
    }
    public String[] getTempStringArray() {
        return tempStringArray;
    }
    public Character getCharx() {
        return charx;
    }
}