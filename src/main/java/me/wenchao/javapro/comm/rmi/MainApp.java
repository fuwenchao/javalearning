package me.wenchao.javapro.comm.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * @Author wenchaofu
 * @DATE 14:30 2018/7/23
 * @DESC
 */
public class MainApp {
    public static void main(String[] args) throws Exception {
//        LocateRegistry.createRegistry(1099);
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        RemoteUnicastServiceImpl remoteService = new RemoteUnicastServiceImpl();
//        Naming.rebind("rmi://127.0.0.1:1099/queryAllUser", remoteService);
        registry.rebind("queryAllUser",remoteService);

        System.out.println("begin ... ");


    }
}
