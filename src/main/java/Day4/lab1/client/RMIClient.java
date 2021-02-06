package Day4.lab1.client;

import Day4.lab1.server.SayHelloService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMIClient {

    public static void main(String[] args) {
        new RMIClient();

    }

    public RMIClient() {

        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            SayHelloService sayHelloService = (SayHelloService) registry.lookup("HelloService");
            String response = sayHelloService.sayHello("Mostafa");
            System.out.println(response);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }


}
