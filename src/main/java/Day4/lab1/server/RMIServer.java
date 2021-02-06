package Day4.lab1.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServer {

    public static void main(String[] args) {
        new RMIServer();
    }
    public RMIServer() {
        try {
            SayHelloService server = new SayHelloServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099); // Default port is 1099, know the difference between create registry and getRegistry()

            registry.bind("HelloService", server);
            System.err.println("Server Ready");


        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

    }



}
