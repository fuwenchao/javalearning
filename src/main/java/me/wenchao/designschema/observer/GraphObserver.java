package me.wenchao.designschema.observer;

/**
 * @Author wenchaofu
 * @DATE 11:14 2018/6/11
 * @DESC
 */
public class GraphObserver implements IObserver {


    @Override
    public void update(NumberGenerator numberGenerator) {
        System.out.println("this is Graph observer-----");
        System.out.println(numberGenerator.getNumber());

    }
}
