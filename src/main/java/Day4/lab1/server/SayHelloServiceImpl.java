package Day4.lab1.server;

import java.rmi.RemoteException;

public class SayHelloServiceImpl implements SayHelloService {

    public SayHelloServiceImpl() throws RemoteException {
        super();
    }
    @Override
    public String sayHello(String name) throws RemoteException {
        return "Hello " + name;
    }
}
