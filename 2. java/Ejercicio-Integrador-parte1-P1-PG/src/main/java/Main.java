import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Crear 3 clientes y guardarlos en una collection
        Collection<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Juan", 12345678));
        clientes.add(new Cliente("María", 23456789));
        clientes.add(new Cliente("Pedro", 34567890));

        // Recorrer la collection de clientes y mostrar los datos de cada uno
        System.out.println("Clientes:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        // Eliminar un cliente de la lista y mostrar los clientes restantes
        Iterator<Cliente> iterator = clientes.iterator();
        iterator.next();
        iterator.remove();

        System.out.println("\nClientes restantes después de eliminar uno:");
        for (Cliente cliente : clientes) {
            System.out.println(cliente);
        }

        // Buscar cliente por número de DNI
        Scanner scanner = new Scanner(System.in);
        System.out.print("\nIngrese el número de DNI a buscar: ");
        int dniBuscar = scanner.nextInt();

        boolean clienteEncontrado = false;
        for (Cliente cliente : clientes) {
            if (cliente.getDni() == dniBuscar) {
                System.out.println("\nCliente encontrado:");
                System.out.println(cliente);
                clienteEncontrado = true;
                break;
            }
        }

        if (!clienteEncontrado) {
            System.out.println("\nCliente no encontrado.");
        }
    }
}
