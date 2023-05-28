import models.Cliente;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Map<Integer, Cliente> mapClientes = new HashMap<>();

        mapClientes.put(9898989, new Cliente("Ricardo","Montoya", 9898989));
        mapClientes.put(6768533, new Cliente("Marta","Montoya", 6768533));
        mapClientes.put(9421455, new Cliente("Miriam","Riquelme", 9421455));

        //MUESTRO LOS CLIENTES CARGADOS
        System.out.println("-----CLIENTE-----");
        mapClientes.forEach((k, v) -> {
            System.out.println("Nombre: " + v.getNombre());
            System.out.println("\nApellido: " + v.getApellido());
            System.out.println("\nDNI: " + v.getDni());
            System.out.println("--------------------");

        });

        //ELIMINO UN CLIENTE Y MUESTRO LOS DATOS DE LOS RESTANTES
        mapClientes.remove(9898989);
        System.out.println("-----CLIENTE RESTANTES-----");
        mapClientes.forEach((k, v) -> {
            System.out.println("Nombre: " + v.getNombre());
            System.out.println("\nApellido: " + v.getApellido());
            System.out.println("\nDNI: " + v.getDni());
            System.out.println("--------------------");
        });

        //CONSULTA DE CLIENTE
        Scanner teclado = new Scanner(System.in);
        Integer dni;
        System.out.println("A CONTINUACION INGRESE EL DNI DEL CLIENTE QUE DESEA VER:\n");
        dni = teclado.nextInt();
        if(mapClientes.containsKey(dni)){
            Cliente encontrado = mapClientes.get(dni);
            System.out.println("PERSONA ENCONTRADA:");
            System.out.println("Nombre: " + encontrado.getNombre());
            System.out.println("\nApellido: " + encontrado.getApellido());
            System.out.println("\nDNI: " + encontrado.getDni());
            System.out.println("--------------------");
        }
        else {
            System.out.println("PERSONA NO ENCONTRADA!!");
        }

    }
}