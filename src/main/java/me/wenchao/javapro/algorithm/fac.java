package me.wenchao.javapro.algorithm;

import com.google.common.hash.HashCode;
import com.sun.deploy.util.StringUtils;

/**
 * @Author wenchaofu
 * @DATE 14:48 2018/6/8
 * @DESC
 */
public class fac {
    private String str = "abc";
    private static long fac(int n){
        if (n == 1) {
            return 1;
        } else {
            return n * fac(n-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(fac(6));
    }
}
