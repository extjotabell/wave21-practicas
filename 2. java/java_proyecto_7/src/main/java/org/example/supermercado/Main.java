package org.example.supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("1", "Ezequiel", "Safdie");
        Cliente cliente2 = new Cliente("2", "Juan", "Perez");
        Cliente cliente3 = new Cliente("3", "Rodrigo", "Lopez");

        List<Cliente> listaClientes = new ArrayList<>() {{
            add(cliente1);
            add(cliente2);
            add(cliente3);
        }};

        listaClientes.forEach(System.out::println);

        buscarCliente(listaClientes);
    }

    public static void buscarCliente(List<Cliente> clientes) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el número de DNI del cliente: ");
        String dniBuscado = scanner.nextLine();
        Cliente clienteBuscado = null;

        for (Cliente cliente : clientes) {
            if (cliente.getDni().equals(dniBuscado)) {
                clienteBuscado = cliente;
            }
        }

        if (clienteBuscado == null) {
            System.out.println("No se encontro cliente con DNI: " + dniBuscado);
        } else {
            System.out.println(clienteBuscado);
        }

    }
}