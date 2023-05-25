import Clases.Cliente;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Supermercado el económico");

        Scanner scanner = new Scanner(System.in);

        ArrayList<Cliente> clientes = new ArrayList<>();
        Cliente cliente1 = new Cliente("123", "Juan", "Perez");
        Cliente cliente2 = new Cliente("456", "Pedro", "Pascal");
        Cliente cliente3 = new Cliente("789", "Cris", "Loasl");
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        imprimirClientes(clientes);

        clientes.remove(2);
        System.out.println("Se elimina posición 2");

        imprimirClientes(clientes);

        System.out.print("Ingresa dni a consultar: ");
        String dniConsultado = scanner.nextLine();

        eliminarCliente(clientes, dniConsultado);

        imprimirClientes(clientes);
    }
    private static void imprimirClientes(ArrayList<Cliente> clientes) {
        // Imprimo una lista de clientes que se recibe como parametro
        for (Cliente cliente : clientes) {
            System.out.println("Nombre: " + cliente.getNombre() + " " + cliente.getApellido());
            System.out.println("DNI: " + cliente.getDni() + "\n");
        }
    }
    private static void eliminarCliente(ArrayList<Cliente> clientes, String dniConsultado) {
        // Elimina un cliente de una lista de clientes, ambos recibidos por parametros
        // Utilizo un iterator para recorrer la lista y modificarla
        // Al utilizar un ciclo for para recorrer la lista, surge una excepción si se modifica en el ciclo
        Iterator<Cliente> iterator = clientes.iterator();
        while (iterator.hasNext()) {
            Cliente cliente = iterator.next();
            if (cliente.getDni().equals(dniConsultado)) {
                iterator.remove();
                System.out.println("Se elimina cliente: " + cliente.getDni() + " " + cliente.getNombre());
            }
        }
    }

}