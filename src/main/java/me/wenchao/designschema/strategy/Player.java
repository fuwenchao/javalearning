package me.wenchao.designschema.strategy;

/**
 * @Author wenchaofu
 * @DATE 11:48 2018/6/12
 * @DESC
 */
public class Player {
    private IStrategy iStrategy;
    private String name;
    private int winCount;
    private int lostCount;
    private int gameCount;

    public Player(IStrategy iStrategy, String name) {
        this.iStrategy = iStrategy;
        this.name = name;
    }

    public Hand nextHand(){
        return iStrategy.nextHand();
    }

    public void win() {
        iStrategy.study(true);
        winCount++;
        gameCount++;
    }
    public void lost() {
        iStrategy.study(false);
        lostCount++;
        gameCount++;

    }
    public void even() {
        gameCount++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "iStrategy=" + iStrategy +
                ", name='" + name + '\'' +
                ", winCount=" + winCount +
                ", lostCount=" + lostCount +
                ", gameCount=" + gameCount +
                '}';
    }
}
