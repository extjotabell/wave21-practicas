package com.bootcamp.wave21;

import com.bootcamp.wave21.model.Cliente;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
        RepositorioDeCliente gestionCliente = new RepositorioDeCliente();
        RepositorioDeFactura gestionFactura = new RepositorioDeFactura(gestionCliente);
        Scanner ingresoTeclado = new Scanner(System.in);
        int menu = 0;

        for (int i = 0; i < 3; i++) {
            clientes.put("3334499" + i, new Cliente("3334499" + i, "Juan" + i, "Martin" + i));
        }
        gestionCliente.setClientes(clientes);
        gestionFactura.setGestorCliente(gestionCliente);
        System.out.println("*****BIENVENIDOS AL GESTOR DEL SUPERMERCADO****");

        while(menu != 3){
            System.out.println("\n1.-Gestor de Cliente\n2.-Factura\n3.-Salir\n:>");
            menu = ingresoTeclado.nextInt();
        switch (menu) {
            case 1:
                gestionCliente.menuGestorCliente();
                break;
            case 2:
                gestionFactura.menuGestorFactura();
                break;

        }
        }

    }
}
