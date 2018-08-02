package me.wenchao.designschema.proxy.givemoney;

/**
 * @Author wenchaofu
 * @DATE 15:39 2018/6/4
 * @DESC 被代理对象
 */

public class Student implements Person{

    private String name;

    public Student(String name) {
        this.name = name;
    }

    @Override
    public void giveMoney() {
        System.out.println(name + "上交班费10000");
    }
}
