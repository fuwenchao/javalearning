package me.wenchao.javabasic.interfacetest;

/**
 * @Author wenchaofu
 * @DATE 15:29 2018/5/28
 * @DESC
 */
public class Apply {
    public static void process(Processor p ,Object s){
        System.out.println("Using processor " + p.name());
        System.out.println(p.process(s));
    }
}
