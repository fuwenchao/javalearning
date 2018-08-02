package me.wenchao.javapro.comm.rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 * @Author wenchaofu
 * @DATE 14:23 2018/7/23
 * @DESC
 */
public interface RemoteServiceInterface extends Remote {
    List<User> queryAllUser() throws RemoteException;
}
