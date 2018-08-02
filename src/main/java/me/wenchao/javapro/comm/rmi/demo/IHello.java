package me.wenchao.javapro.comm.rmi.demo;

/**
 * @Author wenchaofu
 * @DATE 14:57 2018/7/23
 * @DESC
 */
import java.rmi.Remote;

public interface IHello extends Remote {

    public String sayHello(String name) throws java.rmi.RemoteException;

}