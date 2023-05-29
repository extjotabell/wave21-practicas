package Ejercicio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente c1 = new Cliente("DNI1", "Pepe", "Rodriguez");
        Cliente c2 = new Cliente("DNI2", "Juan", "Perez");
        Cliente c3 = new Cliente("DNI3", "Maria", "Gonzalez");

        List<Cliente> clientes = Arrays.asList(c1,c2,c3);
        List<Factura> facturas = new ArrayList<>();

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

        /*Parte 2*/
        Item i1 = new Item("1", "item1", 3, 100);
        Item i2 = new Item("2", "item2", 1, 750);
        List<Item> items = Arrays.asList(i1,i2);

        agregarFacturaAColeccion("DNI4", facturas, clientes, items);


    }
    public static boolean validarCliente(String dni, List<Cliente> clientes) {
        boolean encontrado = false;
        for (int i = 0; i < clientes.size(); i++) {
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
        return encontrado;
    }

    public static Cliente crearCliente (String dni)
    {
        Cliente c = new Cliente(dni);
        return c;
    }

    public static Cliente buscarCliente (String dni, List<Cliente> clientes)
    {
        boolean encontrado = false;
        Cliente c = null;
        for (int i = 0; i < clientes.size(); i++) {
            String dniCliente = clientes.get(i).getDni();
            int esElMismo = dniCliente.compareToIgnoreCase(dni);
            if (esElMismo == 0) {
                c = clientes.get(i);
                encontrado = true;
                break;
            }
        }
        return c;
    }
    public static void agregarFacturaAColeccion(String dni, List<Factura> facturas, List<Cliente> clientes, List<Item> items)
    {
        if(!validarCliente(dni, clientes))
        {
            Cliente c = crearCliente(dni);
            Factura f = new Factura (c, items, calcularTotal(items),1);
            facturas.add(f);
        }
        else
        {
            Cliente c = buscarCliente(dni, clientes);
            Factura f = new Factura (c, items, calcularTotal(items),1);
            facturas.add(f);
        }

    }
    public static int calcularTotal (List<Item> items)
    {
        int total = 0;
        for (int i = 0; i<items.size(); i++)
        {
            total = total + (items.get(i).getCostoUnitario() * items.get(i).getCostoUnitario());
        }
        return total;
    }
}