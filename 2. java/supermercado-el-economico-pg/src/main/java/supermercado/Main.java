package supermercado;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<String,Cliente> clientes = new HashMap();
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("2525","Jose", "Gonzalez");
        Cliente cliente2 = new Cliente("2626","Pepito", "Perez");
        Cliente cliente3 = new Cliente("2727","Sebastian", "Nadal");


        clientes.put(cliente1.getDni(),cliente1);
        clientes.put(cliente2.getDni(),cliente2);
        clientes.put(cliente3.getDni(),cliente3);

        imprimirClientes(clientes);
        eliminarCliente("2727");
        imprimirClientes(clientes);

        System.out.println("\n\n Ingrese el DNI de un cliente que desee ver: ");
        Scanner teclado = new Scanner (System.in);
        String dniTeclado = teclado.nextLine();
        findClientByDNI(dniTeclado);

    }

    private static void findClientByDNI(String dni){
        if(clientes.containsKey(dni)){
            Map<String,Cliente> newMapDNI = new HashMap<>();
            newMapDNI.put(clientes.get(dni).getDni(),clientes.get(dni));
            imprimirClientes(newMapDNI);
        }else{
            System.out.println("El cliente solicitado no existe.");
        }
    }

    private static void eliminarCliente(String dni){
        if(clientes.containsKey(dni)){
            clientes.remove(dni);
            System.out.println("\n\nEl cliente con DNI: " + dni + ". Se ha eliminado");
        }else{
            System.out.println("\n\nEl cliente que intenta eliminar no existe");
        }

    }

    private static void imprimirClientes(Map<String,Cliente> clientes){
        clientes.forEach((dni,cliente) -> {
            System.out.println("----------------------------------------\n" +
                    "Nombre: " + cliente.getNombre() + "\n" +
                    "Apellido: " + cliente.getApellido() + "\n" +
                    "DNI: " + dni);
        });
    }
}
