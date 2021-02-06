package Day4.lab2.client;

import Day4.lab2.server.CalculatorService;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RMICalculatorClient {

    public RMICalculatorClient() {
    }

    public static void main(String[] args) {
        new RMICalculatorClient(args);

    }

    public RMICalculatorClient(String[] args) {

        try {
            // Configuration of RMI
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            CalculatorService calculatorService = (CalculatorService) registry.lookup("CalculatorService");

            // Logic
            int result = handleCalculation(calculatorService, args);
            System.out.println(args[0] + " " + args[1] + " " + args[2] + " = " + result);

        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    private int handleCalculation(CalculatorService calculatorService, String[] args) throws RemoteException {
        int result = 0;
        int param1 = Integer.parseInt(args[0]);
        int param2 = Integer.parseInt(args[2]);
        switch (args[1]) {
            case "+":
                result = calculatorService.add(param1, param2);
                break;
            case "-":
                result = calculatorService.subtract(param1, param2);
                break;
            case "*":
                result = calculatorService.multiply(param1, param2);
                break;
            case "/":
                result = calculatorService.divide(param1, param2);
                break;
            default:
                System.out.println("Not a supported operation");
                break;
        }

        return result;
    }


}
