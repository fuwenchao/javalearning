package me.wenchao.designschema.observer;

/**
 * @Author wenchaofu
 * @DATE 11:12 2018/6/11
 * @DESC
 */
public class DigitObserver implements IObserver{

    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("this is Digit observer-----");
        System.out.println(numberGenerator.getNumber());

    }
}
