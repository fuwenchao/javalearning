package me.wenchao.designschema.strategy;

import java.util.Random;

/**
 * @Author wenchaofu
 * @DATE 11:48 2018/6/12
 * @DESC 随机手势会以之前猜拳结果的概率计算而得
 */
public class ComplexStrategy implements IStrategy {

    private int[][] history = new int[3][3];
    private int preHand = 1;
    private int currentHand = 1;
    Random random = new Random();


    @Override
    public Hand nextHand() {
        int result = random.nextInt(getSum(currentHand)+1);
        int handValue;
        if (result < history[currentHand][0]) {
            handValue = 0;
        } else if (result < history[currentHand][0] + history[currentHand][1]) {
            handValue = 1;
        } else {
            handValue = 2;

        }
        preHand = currentHand;
        currentHand = handValue;
        return Hand.getHand(handValue);
    }

    private int getSum(int currentHand) {
        int sum = 0;
        for (int i = 0; i < 3; i++) {
            sum += history[currentHand][i];
        }
        return sum;
    }

    @Override
    public void study(boolean win) {
        if (win) {
            history[preHand][currentHand]++;

        } else {
            history[preHand][(currentHand + 1) % 3]++;
            history[preHand][(currentHand + 2) % 3]++;
        }

    }
}
