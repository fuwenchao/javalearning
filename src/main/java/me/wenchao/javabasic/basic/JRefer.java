package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 9:59 2018/6/5
 * @DESC
 */
public class JRefer {
    private static StringBuilder sb = new StringBuilder("hello");
    static int[] arr = {1,2,3,4};

    public static void main(String[] args) {
        sb.append(" world");
        System.out.println(sb.toString());
        changString(sb);
        System.out.println(sb.toString());

        System.out.println(arr.length);

    }

    private static StringBuilder changString(StringBuilder sb){
        sb.append(" fuwenchao");
        return sb;
    }
}
