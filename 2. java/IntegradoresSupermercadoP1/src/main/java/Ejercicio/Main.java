package Ejercicio;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("DNI1", "Pepe", "Rodriguez");
        Cliente c2 = new Cliente("DNI2", "Juan", "Perez");
        Cliente c3 = new Cliente("DNI3", "Maria", "Gonzalez");

        List<Cliente> clientes = Arrays.asList(c1,c2,c3);

        /*Mostrar datos de los clientes*/
        clientes.stream().forEach(System.out::println);

        /*Eliminar un cliente*/
        /*clientes.remove(c1);
        clientes.stream().forEach(System.out::println);*/

        /*Solicitar dni*/
        Scanner leer = new Scanner(System.in);
        System.out.println("Ingresar DNI: ");
        String dni = leer.next().toString();
        boolean encontrado = false;
        try {
            for (int i = 0; i < clientes.size() ; i++) {
                String dniCliente = clientes.get(i).getDni();
                int esElMismo = dniCliente.compareToIgnoreCase(dni);
                if (esElMismo == 0) {
                    System.out.println(clientes.get(i).toString());
                    encontrado = true;
                    break;
                }
            }
            if (encontrado == false) {
                System.out.println("No se ha encontrado el cliente: " + dni);
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


    }
}