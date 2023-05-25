package org.example.Supermercado;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(12345, "Juan", "Gomez");
        Cliente cliente2 = new Cliente(23456, "Pedro", "Perez");
        Cliente cliente3 = new Cliente(34567, "Carlos", "Fernandez");

        List<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        imprimir(clientes);
        System.out.println("borremos a Juan");
        clientes.remove(0);
        imprimir(clientes);
        System.out.println("donde esta Juan?");
        buscarPorDNI(12345,clientes);
        buscarPorDNI(23456, clientes);


    }
    public static void imprimir(List<Cliente> clientes){
        for (Cliente cliente : clientes){
            System.out.println(cliente);
        }
    }
    public static void buscarPorDNI(int dni, List<Cliente> clientes){
        boolean encontrado =false;
            for ( int i=0; i<clientes.size(); i++) {
                if (clientes.get(i).getDni() == dni) {
                    encontrado =true;
                    System.out.println(clientes.get(i));
                }
            }
            if (!encontrado){
            System.out.println("No se encuentra el DNI "+dni+" solicitado. Por favor, registre al nuevo cliente");
            }
    }
}
