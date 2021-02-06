package Day4.lab2.server;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMICalculatorServer {

    public static void main(String[] args) {
        new RMICalculatorServer();
    }
    public RMICalculatorServer() {
        try {
            CalculatorService server = new CalculatorServiceImpl();
            Registry registry = LocateRegistry.createRegistry(1099); // Default port is 1099, know the difference between create registry and getRegistry()

            registry.bind("CalculatorService", server);
            System.err.println("Server Ready");


        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }

    }



}
