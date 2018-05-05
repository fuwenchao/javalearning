package me.wenchao.designschema.proxy.jdkproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author wenchaofu
 * @DATE 9:49 2018/5/2
 * @DESC
 */
public class MainApp {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        Car car = new Car();
        InvocationHandler handler = new TimeHandler(car);
        Class<? extends Car> cls = car.getClass();
        MoveAble moveAble = (MoveAble) Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), handler);
        moveAble.move();
    }
}
