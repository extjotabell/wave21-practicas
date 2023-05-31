package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Crear clientes y añadirlos a una lista
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("12345678", "Juan", "Perez"));
        customers.add(new Customer("87654321", "Ana", "Gomez"));
        customers.add(new Customer("56781234", "Pedro", "Martinez"));

        // Recorrer la lista e imprimir los clientes
        for (Customer customer : customers) {
            System.out.println(customer.getDni() + ": " + customer.getFirstName() + " " + customer.getLastName());
        }

        // Eliminar un cliente (por ejemplo, el de DNI 12345678)
        Iterator<Customer> iterator = customers.iterator();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            if (customer.getDni().equals("12345678")) {
                iterator.remove();
            }
        }

        // Volver a imprimir los clientes restantes
        for (Customer customer : customers) {
            System.out.println(customer.getDni() + ": " + customer.getFirstName() + " " + customer.getLastName());
        }

        // Solicitar un DNI por teclado y buscarlo en la lista
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese un DNI para buscar:");
        String dni = scanner.nextLine();
        boolean found = false;
        for (Customer customer : customers) {
            if (customer.getDni().equals(dni)) {
                System.out.println("Cliente encontrado: " + customer.getFirstName() + " " + customer.getLastName());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Cliente no encontrado.");
        }
    }
}
