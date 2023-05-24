package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Cliente cliente1 = new Cliente(1, "Pepe", "Garcia");
        Cliente cliente2 = new Cliente(2, "Pedro", "Gonzales");
        Cliente cliente3 = new Cliente(3, "Pablo", "Rodriguez");

        List<Cliente> clienteList = new ArrayList<>();

        clienteList.add(cliente1);
        clienteList.add(cliente2);
        clienteList.add(cliente3);

        System.out.println("");
        System.out.println("Clientes agregados");
        System.out.println("");

        for (Cliente cliente : clienteList ) {
            System.out.println(cliente);
        }

        clienteList.remove(cliente2);

        System.out.println("");
        System.out.println("Cliente 2 robado");
        System.out.println("");

        for (Cliente cliente : clienteList ) {
            System.out.println(cliente);
        }

        Scanner myObj = new Scanner(System.in);
        System.out.println("Ingresar DNI de Cliente: ");
        int dni = myObj.nextInt();

        for(int i=0; i < clienteList.size(); i++) {
            if(dni == clienteList.get(i).dni) {
                System.out.println(clienteList.get(i));
            } else {
                System.out.println("Cliente no encontrado");
            }
        }

    }
}