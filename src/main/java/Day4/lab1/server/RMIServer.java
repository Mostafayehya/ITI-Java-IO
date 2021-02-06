package Day4.lab1.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer  {

    public RMIServer() {
    }

    public static void main(String[] args) {
        try {
            SayHelloService server =new SayHelloServiceImpl();
            SayHelloService stub = (SayHelloService) UnicastRemoteObject
                    .exportObject((SayHelloService) server,0);

            Registry registry = LocateRegistry.createRegistry(1099); // Default port is 1099

            registry.bind("HelloService",stub);
            System.err.println("Server Ready");


        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

}
}
