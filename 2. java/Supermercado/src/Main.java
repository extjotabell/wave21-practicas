import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        //Crear colleccion clientes
        ArrayList<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(new Cliente("123456789", "Ernesto", "Perez"));
        clientes.add(new Cliente("987654321", "Arnulfo", "Rodriguez"));
        clientes.add(new Cliente("678954321", "Andrea", "Gutierrez"));

        //Recorrer la coleccion y mostrar en pantalla
        clientes.forEach(System.out::println);

        //Eliminar un cliente y mostrar por pantalla
        System.out.println("Se elimina el cliente con dni 123456789");
        clientes.removeIf(cliente -> cliente.getDni().equals("123456789"));
        clientes.forEach(System.out::println);

        //Consultar cliente por ingreso de usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente a consultar: ");
        String dni = scanner.next();
        Optional<Cliente> clienteBuscado = clientes.stream().filter(cliente -> cliente.getDni().equals(dni)).findFirst();
        if(clienteBuscado.isPresent()){
            System.out.println("Datos del cliente: " + clienteBuscado);
        }else {
            System.out.println("No se encontró ningun cliente con este dni");
        }
    }
}