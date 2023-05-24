package Supermercado;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(1234567L, "Marcos", "Rodriguez");
        Cliente cliente2 = new Cliente(3454677L, "Sofia", "Perez");
        Cliente cliente3 = new Cliente(8796554L, "Marcelo", "Fabiani");

        List<Cliente> clientes = new ArrayList<Cliente>();
        clientes.add(cliente1);
        clientes.add(cliente2);
        clientes.add(cliente3);

        for (Cliente c : clientes) {
            System.out.println(c.toString());
        }


        boolean salir = false;

        while (!salir) {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("1 - Borrar Cliente. \n2 - Mostrar Cliente\n3 - Salir.\nIngrese la opcion que desea realizar:");
            int opcion = keyboard.nextInt();

            switch (opcion) {
                case 1:

                    System.out.println("Ingrese el dni de la persona a borrar");
                    Long dniABorrar = keyboard.nextLong();

                    boolean flag = false;
                    for (Cliente c : clientes) {
                        if (c.getDni().equals(dniABorrar)) {
                            clientes.remove(c);
                            flag = true;
                            break;
                        }
                    }

                    if (flag == false) {
                        System.out.println("No existe el cliente!");
                    } else
                        System.out.println("Cliente eliminado con éxito!");

                    break;

                case 2:
                    System.out.println("Ingrese el dni del Cliente a buscar:");
                    Long dniABuscar = keyboard.nextLong();

                    boolean flag2 = false;
                    for (Cliente c : clientes) {
                        if (c.getDni().equals(dniABuscar)) {
                            System.out.println(c.toString());
                            flag2 = true;
                            break;
                        }
                    }

                    if (flag2 == false) {
                        System.out.println("No se encontro el Cliente!");
                    }

                    break;

                case 3:
                    salir = true;
                    break;
                default:
                    break;
            }
        }
    }
}

