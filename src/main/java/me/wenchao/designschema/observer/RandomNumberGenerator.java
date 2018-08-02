package me.wenchao.designschema.observer;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * @Author wenchaofu
 * @DATE 11:21 2018/6/11
 * @DESC
 */
public class RandomNumberGenerator extends NumberGenerator {

    private Random random = new Random();
    private int number;


    @Override
    public int getNumber() {
        return number;
    }

    @Override
    public void executor() {
        System.out.println("this is randomGenerator ---- ");
        number = random.nextInt(50);
        System.out.println("begin to notify to observer");
        notifyAllOB();

    }
}
