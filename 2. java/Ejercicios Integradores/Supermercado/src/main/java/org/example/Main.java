package org.example;

import java.util.Optional;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Supermercado supermercado = new Supermercado();
        Cliente c1 = new Cliente("Nombre1", "Apellido1", "dni1");
        Cliente c2 = new Cliente("Nombre2", "Apellido2", "dni2");
        Cliente c3 = new Cliente("Nombre3", "Apellido3", "dni3");

        supermercado.agregarCliente(c1);
        supermercado.agregarCliente(c2);
        supermercado.agregarCliente(c3);

        supermercado.mostrarClientes();

        System.out.println("********************");

        supermercado.eliminarCliente(c1);
        supermercado.mostrarClientes();


        System.out.println("--------ENTRA POR CONSOLA-------");

        Scanner entradaEscaner = new Scanner (System.in);
        String entradaTeclado = entradaEscaner.nextLine();
        Optional<Cliente> clienteIngresado = supermercado.dniEsCliente(entradaTeclado);

        if(clienteIngresado== null) {
            System.out.println("NO EXISTE EL CLIENTE");
        } else {
            clienteIngresado.get().mostrarDatos();
        }

    }
}