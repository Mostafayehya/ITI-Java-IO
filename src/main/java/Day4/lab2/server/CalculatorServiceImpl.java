package Day4.lab2.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorServiceImpl extends UnicastRemoteObject implements CalculatorService {

    public CalculatorServiceImpl() throws RemoteException {
        super();
    }

    @Override
    public int add(int parm1, int parm2) throws RemoteException {
        return parm1 + parm2;
    }

    @Override
    public int subtract(int parm1, int parm2) throws RemoteException {
        return parm1 - parm2;
    }

    @Override
    public int multiply(int parm1, int parm2) throws RemoteException {
        return parm1 * parm2;
    }

    @Override
    public int divide(int dividend, int divisor) throws RemoteException {
        return dividend / divisor;
    }
}
