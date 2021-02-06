package Day4.lab2.server;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CalculatorService extends Remote, Serializable {

    int add(int parm1,int parm2) throws RemoteException;
    int subtract(int parm1,int parm2) throws RemoteException;
    int multiply(int parm1,int parm2) throws RemoteException;
    int divide(int dividend,int divisor) throws RemoteException;
}
