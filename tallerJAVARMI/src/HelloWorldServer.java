import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloWorldServer implements HelloWorldInterface {

    public HelloWorldServer() {}

    public String sayHello() {
        return "Hello world from the server";
    }

    public static void main(String[] args) {
        try {
            HelloWorldServer server = new HelloWorldServer();
            HelloWorldInterface stub = (HelloWorldInterface) UnicastRemoteObject.exportObject(server, 0);
            Registry registry = LocateRegistry.createRegistry(1099);
            registry.bind("HelloWorld", stub);
            System.out.println("Servidor listo");
        } catch (Exception e) {
            System.err.println("Error en el servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
