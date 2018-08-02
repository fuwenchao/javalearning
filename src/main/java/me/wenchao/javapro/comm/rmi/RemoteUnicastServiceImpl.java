package me.wenchao.javapro.comm.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 14:26 2018/7/23
 * @DESC
 */
public class RemoteUnicastServiceImpl extends UnicastRemoteObject implements RemoteServiceInterface {
    protected RemoteUnicastServiceImpl() throws RemoteException {
        super();
    }
    private static final long serialVersionUID = 1L;


    @Override
    public List<User> queryAllUser() throws RemoteException {
        List<User> lUser = new ArrayList<>();
        User user1 = new User();
        user1.setUserName("wenchaofu");
        user1.setUserDesc("genius");
        user1.setUserAge("28");
        user1.setUserSex("male");
        lUser.add(user1);
        return lUser;

    }
}
