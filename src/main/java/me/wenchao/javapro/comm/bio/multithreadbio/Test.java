package me.wenchao.javapro.comm.bio.multithreadbio;

import java.util.Arrays;

/**
 * @Author wenchaofu
 * @DATE 17:14 2018/7/20
 * @DESC
 */
public class Test {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        while (true) {
            System.out.println("before");
            while (true) {
                System.out.println("inner while");
                sb.append(new String("123"));
                break;
            }
            System.out.println("after");
            break;
        }
        sb.append("-------");
        sb.append("B");
        System.out.println(sb);
    }
}
