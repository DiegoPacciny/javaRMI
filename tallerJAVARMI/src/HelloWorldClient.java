import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class HelloWorldClient {

    private HelloWorldClient() {}

    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost");
            HelloWorldInterface stub = (HelloWorldInterface) registry.lookup("HelloWorld");
            String response = stub.sayHello();
            System.out.println("Respuesta del servidor: " + response);
        } catch (Exception e) {
            System.err.println("Error en el cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
