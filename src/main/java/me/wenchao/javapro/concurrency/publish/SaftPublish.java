package me.wenchao.javapro.concurrency.publish;

import me.wenchao.annotation.NotThreadSafe;
import me.wenchao.annotation.ThreadSafe;

import java.util.Arrays;

/**
 * @Author wenchaofu
 * @DATE 11:45 2018/6/13
 * @DESC
 */
@ThreadSafe
public class SaftPublish {
    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        SaftPublish unsaftPublish = new SaftPublish();
        System.out.println(Arrays.toString(unsaftPublish.getStates()));
        unsaftPublish.getStates()[0] = "d";
        System.out.println(Arrays.toString(unsaftPublish.getStates()));
    }
}
