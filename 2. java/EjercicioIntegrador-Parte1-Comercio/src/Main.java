import Clases.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Creacion Clientes
        Cliente cliente1 = new Cliente("12345678", "Juan", "Perez");
        Cliente cliente2 = new Cliente("87654321B", "María", "Gomez");
        Cliente cliente3 = new Cliente("54321678", "Pedro", "Lopez");

        // Creacion de la coleccion y cargo los clientes
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        // Imprimo los clientes
        clientes.stream().forEach(c-> System.out.println(c.toString()));

        // Leo por teclado el DNI que deseo eliminar
        Scanner input = new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("Ingrese el DNI del Cliente a eliminar");
        String dniClienteABorrar = input.next();
        System.out.println("------------------");

        boolean clienteEliminado = false;

        for (Cliente c: clientes) {
            if (c.getDni().equals(dniClienteABorrar)){
                clientes.remove(c);
                clienteEliminado = true;
                break;
            }
        }

        if (clienteEliminado){
            System.out.println("El Cliente ha sido eliminado con exito");
        }
        else {
            System.out.println("No se ha encontrado el Cliente solicitado");
        }
        System.out.println("------------------");
        System.out.println("Clientes restantes:");
        clientes.forEach(c -> System.out.println(c.toString()));

        System.out.println("------------------");
        System.out.println("Ingrese el DNI del Cliente a buscar");
        String dniClienteABuscar = input.next();
        System.out.println("------------------");

        Cliente cli = (Cliente) clientes.stream()
                .filter(cliente -> cliente.getDni().equals(dniClienteABuscar))
                .findFirst()
                .orElse(null);

        if (cli != null){
            System.out.println("Cliente encontrado, sus datos son: ");
            System.out.println(cli.toString());
        }
        else {
            System.out.println("Cliente no encontrado");
        }
    }
}