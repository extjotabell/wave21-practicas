package supermercado;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Supermercado supermercado = new Supermercado();

        Cliente juan = new Cliente("Juan", "Perez", "41818181");
        Cliente pedro = new Cliente("Pedro", "Perez", "41828181");
        Cliente gonzalo =new Cliente("Gonzalo", "Perez", "41518181");

        supermercado.agregar(juan);
        supermercado.agregar(pedro);
        supermercado.agregar(gonzalo);


        System.out.println("Clientes inciales");
        supermercado.imprimirClientes();

        //Eliminar
        supermercado.eliminar(pedro.obtenerDni());

        System.out.println();
        System.out.println("Clientes sin Pedro");
        supermercado.imprimirClientes();

        //Buscar
        System.out.println();
        System.out.println("-----------------------------------------------------------");

        System.out.println("Ingrese el DNI del cliente a buscar sin puntos ni espacios");

        Scanner teclado = new Scanner(System.in);
        String dni = teclado.next();

        Cliente cliente = supermercado.buscar(dni);

        if(cliente != null){
            cliente.mostrar();
        }else{
            System.out.println("No se encontro un usuario con dni " + dni);
        }

        //Parte II
        Item papa = new Item(1,1,50, "papa");
        Item zanahoria = new Item(1,2,50, "zanahoria");
        ArrayList<Item> items = new ArrayList<>();
        items.add(papa);
        items.add(zanahoria);

        Factura factura = new Factura(juan,items);

        Cliente noCliente = new Cliente("Juan", "Perez", "54987987");
        Factura facturaNoCliente = new Factura(noCliente,items);

        supermercado.agregar(factura);

        supermercado.agregar(facturaNoCliente);


    }
}
