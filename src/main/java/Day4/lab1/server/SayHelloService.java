package Day4.lab1.server;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface SayHelloService extends Remote, Serializable {

    String sayHello(String name) throws RemoteException;
}
