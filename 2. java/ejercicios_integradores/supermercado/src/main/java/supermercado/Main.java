package supermercado;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        HashMap<String,Cliente> clientes = new HashMap();


        Cliente juan = new Cliente("Juan", "Perez", "41818181");
        Cliente pedro = new Cliente("Pedro", "Perez", "41828181");
        Cliente gonzalo =new Cliente("Gonzalo", "Perez", "41518181");

        clientes.put(juan.obtenerDni(), juan);
        clientes.put(pedro.obtenerDni(), pedro);
        clientes.put(gonzalo.obtenerDni(), gonzalo);

        System.out.println("Clientes inciales");
        clientes.values().forEach(Cliente::mostrar);

        clientes.remove(pedro.obtenerDni());

        System.out.println();
        System.out.println("Clientes sin Pedro");



        clientes.values().forEach(Cliente::mostrar);


        System.out.println();
        System.out.println("-----------------------------------------------------------");

        System.out.println("Ingrese el DNI del cliente a buscar sin puntos ni espacios");

        Scanner teclado = new Scanner(System.in);
        String dni = teclado.next();

        Cliente cliente = clientes.get(dni);

        if(cliente != null){
            cliente.mostrar();
        }else{
            System.out.println("No se encontro un usuario con dni " + dni);
        }

        
    }
}
