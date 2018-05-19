package me.wenchao.javabasic.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 14:59 2018/5/18
 * @DESC
 * -XX:PermSize=5M -XX:MaxPermSize=5M
 */
public class PermOOM {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        int i = 0 ;
        while (true) {

            list.add(String.valueOf(i++).intern());
            System.out.println(i);
        }


    }
}
