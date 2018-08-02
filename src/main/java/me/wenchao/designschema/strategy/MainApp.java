package me.wenchao.designschema.strategy;

/**
 * @Author wenchaofu
 * @DATE 11:49 2018/6/12
 * @DESC
 */
public class MainApp {
    public static void main(String[] args) {
        Player player1 = new Player(new SimpleStrategy(),"wenchaofu");
        Player player2 = new Player(new ComplexStrategy(), "wcf");
        for (int i = 0; i < 100; i++) {
            Hand hand1 = player1.nextHand();
            Hand hand2 = player2.nextHand();
            if (hand1.isStrongerThan(hand2)) {
                System.out.println("winner  is " + player1);
                player1.win();
                player2.lost();
            } else if (hand1.isWeakThan(hand2)) {
                System.out.println("winner is " + player2);
                player1.lost();
                player2.win();
            } else {
                System.out.println("even");
                player1.even();
                player2.even();
            }
        }
    }
}
