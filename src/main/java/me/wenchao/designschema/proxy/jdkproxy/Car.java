package me.wenchao.designschema.proxy.jdkproxy;

/**
 * @Author wenchaofu
 * @DATE 9:42 2018/5/2
 * @DESC
 */
public class Car implements MoveAble{
    public void move(){

        try {
            System.out.println("汽车行驶中......");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
