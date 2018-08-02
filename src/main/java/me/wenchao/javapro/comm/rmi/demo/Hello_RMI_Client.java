package me.wenchao.javapro.comm.rmi.demo;

/**
 * @Author wenchaofu
 * @DATE 14:58 2018/7/23
 * @DESC
 */
import java.rmi.Naming;
public class Hello_RMI_Client {
    public static void main(String[] args) {
        try {
            IHello hello = (IHello) Naming.lookup("rmi://localhost:1099/hello");
            System.out.println(hello.sayHello("zhangxianxin"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}