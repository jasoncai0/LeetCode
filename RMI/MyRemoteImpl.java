package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by zhensheng on 2016/8/10.
 */
public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {
    protected MyRemoteImpl() throws RemoteException {
    }

    @Override
    public String sayHello() throws RemoteException {
        return "Server says ,'hey' ";
    }
    public static void main(String args[]){
        try {
            MyRemote service= new MyRemoteImpl();
            /*

             */
            LocateRegistry.createRegistry(8888);


            Naming.rebind("rmi://localhost:8888/myRemote",service);
            //Naming.rebind("RemoteHello",service);

            System.out.println("chenggong");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }
}
