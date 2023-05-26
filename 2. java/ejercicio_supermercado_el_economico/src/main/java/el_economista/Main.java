package el_economista;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Cliente> clientes = new ArrayList<>();

        Cliente cliente1 = new Cliente("1", "Juan", "Pérez");
        Cliente cliente2 = new Cliente("2", "Carlos", "Cabal");
        Cliente cliente3 = new Cliente("3", "Gaston", "La Parca");
        clientes.addAll(List.of(cliente1, cliente2, cliente3));

        System.out.println("Mostrando los clientes de la colección");
        clientes.forEach(System.out::println);

        System.out.println("Eliminando al cliente con dni " + cliente2.getDni());
        clientes.remove(cliente2);

        System.out.println("Mostrando lista luego de la eliminación");
        clientes.forEach(System.out::println);

        buscarClienteDesdeTeclado(clientes);

        //Segundo Sprint
        Item producto1 = new Item(1,"Producto 1", 3, 25);
        Item producto2 = new Item(2,"Producto 2", 5, 10);
        Factura factura = new Factura(cliente1,List.of(producto1,producto2));
        System.out.println(factura);
    }

    private static void buscarClienteDesdeTeclado(List<Cliente> clientes){
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese un dni: ");
        String dni = sc.next();
        Cliente clienteBuscado = clientes.stream().filter(c -> c.getDni().equals(dni)).findAny().orElse(null);
        if (clienteBuscado == null) {
            System.out.println("No se encontro un cliente con el dni ingresado");
        } else {
            System.out.println(clienteBuscado);
        }
    }

}
