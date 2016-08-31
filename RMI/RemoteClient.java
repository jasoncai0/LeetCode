package RMI;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

/**
 * Created by zhensheng on 2016/8/10.
 */
public class RemoteClient {
    public static void main(String args[]){
        try {

            //MyRemote service = new MyRemoteImpl();
            MyRemote service = (MyRemote) Naming.lookup("rmi://localhost:8888/myRemote");
            System.out.println(service.sayHello());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

    }
}
