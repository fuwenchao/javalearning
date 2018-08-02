package me.wenchao.javapro.concurrency.publish;

import me.wenchao.annotation.NotThreadSafe;

import java.util.Arrays;

/**
 * @Author wenchaofu
 * @DATE 11:45 2018/6/13
 * @DESC
 */
@NotThreadSafe
public class UnsaftPublish {
    private String[] states = {"a", "b", "c"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsaftPublish unsaftPublish = new UnsaftPublish();
        System.out.println(Arrays.toString(unsaftPublish.getStates()));
        unsaftPublish.getStates()[0] = "d";
        System.out.println(Arrays.toString(unsaftPublish.getStates()));
    }
}
