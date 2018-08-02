package me.wenchao.designschema.proxy.givemoney;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @Author wenchaofu
 * @DATE 15:46 2018/6/4
 * @DESC
 */
public class MainApp {
    public static void main(String[] args) {
        InvocationHandler timeHandler = new TimeHandler(new Student("wenchaofu"));
        Person p = (Person)Proxy.newProxyInstance(Person.class.getClassLoader(),new Class[]{Person.class},timeHandler);
        p.giveMoney();
    }
}
