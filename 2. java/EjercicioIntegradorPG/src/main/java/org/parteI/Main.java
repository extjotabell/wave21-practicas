package org.parteI;

import org.parteI.logic.facturaCliente;
import org.parteI.logic.crudCliente;
import org.parteI.logic.iCrudCliente;
import org.parteI.logic.iFacturaCliente;
import org.parteI.model.Cliente;
import org.parteI.model.Item;

import java.util.*;

public class Main {

    static iCrudCliente vICrudCliente = new crudCliente();
    static iFacturaCliente vIFacturaCliente = new facturaCliente();
    static List<Item> itemList = new ArrayList<>();


    public static void main(String[] args) {

        vICrudCliente.crearCliente(12345L, "Maria", "Perez");
        vICrudCliente.crearCliente(13467L, "Jose", "Lopez");
        vICrudCliente.crearCliente(98765L, "Camilo", "Soto");

        itemList.add(new Item(1, "Leche", 6, 3000));
        itemList.add(new Item(2, "Manzana", 2, 2000));
        itemList.add(new Item(3, "Atun", 3, 5700));
        itemList.add(new Item(4, "Arroz", 4, 1500));

        Cliente cliente1 = vICrudCliente.consultarClientes(12345L).get(0);
        Cliente cliente2 = vICrudCliente.consultarClientes(13467L).get(0);
        Cliente cliente3 = vICrudCliente.consultarClientes(98765L).get(0);

        vIFacturaCliente.crearFactura(1, cliente1, itemList);
        vIFacturaCliente.crearFactura(2, cliente2, itemList.stream().filter(item -> item.getCodigo() == 2).toList());
        vIFacturaCliente.crearFactura(3, cliente3, itemList.stream().filter(item -> item.getNombrePro().contains("n")).toList());


        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1. Crear Cliente");
            System.out.println("2. Consultar todos los Clientes");
            System.out.println("3. Consultar Cliente por Dni");
            System.out.println("4. Actualizar Cliente por Dni");
            System.out.println("5. Eliminar Cliente por Dni");
            System.out.println("6. Consultar todas las Facturas");
            System.out.println("7. Consultar factura por Codigo");
            System.out.println("8. Eliminar Factura por codigo");
            System.out.println("9. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has seleccionado la opcion 1");
                        crearCliente();
                        break;
                    case 2:
                        System.out.println("Has seleccionado la opcion 2");
                        vICrudCliente.imprimirClientes(vICrudCliente.consultarClientes());
                        break;
                    case 3:
                        System.out.println("Has seleccionado la opcion 3");
                        System.out.println("Ingrese el Dni del cliente a consultar: ");
                        vICrudCliente.imprimirClientes(vICrudCliente.consultarClientes(sn.nextLong()));
                        break;
                    case 4:
                        System.out.println("Has seleccionado la opcion 4");
                        actualizarCliente();
                        break;
                    case 5:
                        System.out.println("Has seleccionado la opcion 5");
                        System.out.println("Ingrese el Dni del cliente a eliminar: ");
                        vICrudCliente.eliminarCliente(sn.nextLong());
                        break;
                    case 6:
                        System.out.println("Has seleccionado la opcion 6");
                        vIFacturaCliente.consultarFacturas();
                        break;
                    case 7:
                        System.out.println("Has seleccionado la opcion 7");
                        System.out.println("Ingrese el codigo del producto a consultar: ");
                        vIFacturaCliente.consultarFacturas(sn.nextLong());
                        break;
                    case 8:
                        System.out.println("Has seleccionado la opcion 8");
                        System.out.println("Ingrese el codigo de la factura a eliminar: ");
                        vIFacturaCliente.eliminarFactura(sn.nextLong());
                        break;
                    case 9:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 8");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    private static void crearCliente() {

        Scanner sn = new Scanner(System.in);
        System.out.println("ingrese el dni del cliente: ");
        long dni = sn.nextLong();
        System.out.println("ingrese el nombre del cliente: ");
        String nombre = sn.next();
        System.out.println("ingrese el apellido del cliente: ");
        String apellido = sn.next();

        //Agrega cliente nuevo
        vICrudCliente.crearCliente(dni, nombre, apellido);

    }

    private static void actualizarCliente() {

        Scanner sn = new Scanner(System.in);
        System.out.println("ingrese el dni del cliente a actualizar: ");
        long dni = sn.nextLong();
        System.out.println("ingrese el nombre del cliente a actualizar: ");
        String nombre = sn.next();
        System.out.println("ingrese el apellido del cliente a actualizar: ");
        String apellido = sn.next();

        //Actualizar cliente
        vICrudCliente.actualizarCliente(dni,nombre,apellido);

    }


}