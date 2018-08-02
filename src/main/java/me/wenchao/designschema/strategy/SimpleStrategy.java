package me.wenchao.designschema.strategy;

import java.util.Random;

/**
 * @Author wenchaofu
 * @DATE 11:47 2018/6/12
 * @DESC
 */
public class SimpleStrategy implements IStrategy {

    private boolean won = false ;
    private Hand preHand ;
    Random random = new Random();

    @Override
    public Hand nextHand() {
        if(!won){
            preHand = Hand.getHand(random.nextInt(3));
        }
        return preHand;
    }

    @Override
    public void study(boolean win) {
        this.won = win;
    }
}
