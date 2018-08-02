package me.wenchao.designschema.strategy;

/**
 * @Author wenchaofu
 * @DATE 11:45 2018/6/12
 * @DESC
 */
public interface IStrategy {
    Hand nextHand();
    void study(boolean win);
}
