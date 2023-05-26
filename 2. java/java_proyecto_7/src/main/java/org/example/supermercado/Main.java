package org.example.supermercado;

import org.example.supermercado.repository.ClienteImp;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ClienteImp clienteImp = new ClienteImp();

        Cliente cliente1 = new Cliente("1", "Ezequiel", "Safdie");
        Cliente cliente2 = new Cliente("2", "Juan", "Perez");
        Cliente cliente3 = new Cliente("3", "Rodrigo", "Lopez");

        clienteImp.guardar(cliente1);
        clienteImp.guardar(cliente2);
        clienteImp.guardar(cliente3);

//        clienteImp.imprimirPantalla();

//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Ingrese el número de DNI del cliente: ");
//        String dniBuscado = scanner.nextLine();
//        Optional<Cliente> clienteBuscado = clienteImp.buscar(dniBuscado);
//        if(clienteBuscado.isPresent()) System.out.println(clienteBuscado);

        clienteImp.eliminar("2");
        clienteImp.imprimirPantalla();

//        buscarCliente(listaClientes);

        Factura factura = new Factura(cliente1);

//        if(!validarCliente(listaClientes, factura)){
//            listaClientes.add(factura.getCliente());
//        }

        Item item1 = new Item("1", "Leche", 2, 10);
        Item item2 = new Item("2", "Yerba Mate", 5, 5);

        List<Item> itemList = new ArrayList<>(){{
            add(item1);
            add(item2);
        }};

        factura.setItemsYCalcularTotal(itemList);

        System.out.println(factura);
    }

//    public static void buscarCliente(List<Cliente> clientes) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Ingrese el número de DNI del cliente: ");
//        String dniBuscado = scanner.nextLine();
//        Cliente clienteBuscado = null;
//
//        for (Cliente cliente : clientes) {
//            if (cliente.getDni().equals(dniBuscado)) {
//                clienteBuscado = cliente;
//            }
//        }
//
//        if (clienteBuscado == null) {
//            System.out.println("No se encontro cliente con DNI: " + dniBuscado);
//        } else {
//            System.out.println(clienteBuscado);
//        }
//
//    }

    public static boolean validarCliente(List<Cliente> clientesActuales, Factura factura){
        return clientesActuales.contains(factura.getCliente());
    }
}