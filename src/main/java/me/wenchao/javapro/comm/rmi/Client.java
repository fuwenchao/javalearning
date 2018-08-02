package me.wenchao.javapro.comm.rmi;

import java.rmi.Naming;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 14:33 2018/7/23
 * @DESC
 */
public class Client {
    public static void main(String[] args) throws Exception {
        RemoteServiceInterface remoteServiceInt = (RemoteServiceInterface) Naming.lookup("rmi://127.0.0.1:1099/queryAllUser");
        List<User> lUser = remoteServiceInt.queryAllUser();
        for (User user : lUser) {
            System.out.println(user.toString());
        }

    }
}
