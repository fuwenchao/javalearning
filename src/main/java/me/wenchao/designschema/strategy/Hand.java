package me.wenchao.designschema.strategy;

/**
 * @Author wenchaofu
 * @DATE 11:46 2018/6/12
 * @DESC
 */
public class Hand {
    public static final int SHITOU = 0;
    public static final int JIANDAO = 1;
    public static final int BU = 2;
    private static final String[] name = {"石头","剪刀","布"};
    private static final Hand[] hand = {
            new Hand(SHITOU),
            new Hand(JIANDAO),
            new Hand(BU)
    };

    private int handvalue;

    private Hand(int handvalue) {
        this.handvalue = handvalue;
    }
    public static Hand getHand(int handvalue){
        return hand[handvalue%3];

    }
    public boolean isStrongerThan(Hand hand){
        return fight(hand) == 1;
    }

    public boolean isWeakThan(Hand hand) {
        return fight(hand) == -1;
    }

    private int fight(Hand hand) {

        if (this == hand) {
            return 0;
        } else if ((this.handvalue + 1) % 3 == hand.handvalue) {
            return 1;

        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return name[handvalue];
    }
}
