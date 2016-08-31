package RMI;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * Created by zhensheng on 2016/8/10.
 */
public interface MyRemote extends Remote {
    public String sayHello() throws RemoteException;
}
