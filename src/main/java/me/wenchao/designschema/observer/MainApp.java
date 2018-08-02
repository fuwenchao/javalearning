package me.wenchao.designschema.observer;

/**
 * @Author wenchaofu
 * @DATE 11:25 2018/6/11
 * @DESC
 */
public class MainApp {
    public static void main(String[] args) {
        IObserver iObserver1 = new DigitObserver();
        IObserver iObserver2 = new GraphObserver();
        NumberGenerator numberGenerator = new RandomNumberGenerator();
        numberGenerator.register(iObserver1);
        numberGenerator.register(iObserver2);
        numberGenerator.executor();
    }
}
