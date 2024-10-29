import java.rmi.Remote;
import java.rmi.RemoteException;

public interface HelloWorldInterface extends Remote {
    String sayHello() throws RemoteException;
}
