package me.wenchao.javabasic.basic;

/**
 * @Author wenchaofu
 * @DATE 17:48 2018/6/8
 * @DESC
 */
public class IsChinese {
    private static boolean isChinese(char c){
        String s = String.valueOf(c);
        s.hashCode();
        return s.getBytes().length > 1 ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(isChinese('f'));
    }
}
