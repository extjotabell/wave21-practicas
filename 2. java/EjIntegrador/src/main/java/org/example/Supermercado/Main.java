package org.example.Supermercado;

import org.example.Supermercado.model.Cliente;
import org.example.Supermercado.model.Item;
import org.example.Supermercado.repository.RepoCliente;
import org.example.Supermercado.repository.RepoFactura;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepoCliente clientes = new RepoCliente();
        RepoFactura facturas = new RepoFactura();
        Cliente cliente1 = new Cliente(12345, "Juan", "Gomez");
        Cliente cliente2 = new Cliente(23456, "Pedro", "Perez");
        Cliente cliente3 = new Cliente(34567, "Carlos", "Fernandez");

        clientes.guardar(cliente1);
        clientes.guardar(cliente2);
        clientes.guardar(cliente3);


        clientes.imprimir(); //muestro a todos los clientes
        System.out.println("borremos a Juan");
        clientes.eliminar(12345); // borro a Juan

        clientes.imprimir(); //muestro a todos los clientes sin Juan
        System.out.println("donde esta Juan?");
        clientes.buscarPorID(12345); // busco a juan
        clientes.buscarPorID(23456); // busco a un cliente
        clientes.eliminar(22222); //se trata de eliminar a un cliente no registrado

        Item item1 = new Item(123, "leche", 2, 150);
        Item item2 = new Item(124, "harina", 1, 100);
        List<Item> itemsComprados = new ArrayList<>();
        itemsComprados.add(item1);
        itemsComprados.add(item2);
        System.out.println("Genero factura de un nuevo cliente");
        facturas.generarFactura(clientes, cliente1, itemsComprados);
        System.out.println("Genero factura de un cliente ya ingresado");
        facturas.generarFactura(clientes, cliente2, itemsComprados);

        facturas.imprimir();
    }
}
