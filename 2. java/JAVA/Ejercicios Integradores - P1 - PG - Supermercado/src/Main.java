import model.Cliente;
import repository.ClienteImp;
import repository.FacturaImp;
import repository.ItemImp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClienteImp cliImp = new ClienteImp();
        FacturaImp factImp = new FacturaImp();
        ItemImp itemImp = new ItemImp();

        Cliente cliente1 = new Cliente(1234567L, "Marcos", "Rodriguez");
        Cliente cliente2 = new Cliente(3454677L, "Sofia", "Perez");
        Cliente cliente3 = new Cliente(8796554L, "Marcelo", "Fabiani");

        cliImp.save(cliente1);
        cliImp.save(cliente2);
        cliImp.save(cliente3);

        Scanner keyboard = new Scanner(System.in);
/*
        cliImp.save(cliente1); //Guardando un cliente

        cliImp.mostrarPantalla(); //Mostrando en pantalla a todos los clientes

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Ingrese el dni del Cliente a buscar:");
        Long dniABuscar = keyboard.nextLong();
        cliImp.buscar(dniABuscar); //Se busca por teclado un cliente

        System.out.println("Ingrese el dni del Cliente a borrar:");
        Long dniABorrar = keyboard.nextLong();
        cliImp.eliminar(dniABorrar);
  */
        boolean salir = false;
        while(!salir){
            System.out.println("\n1-Cliente.\n2-Factura.\n3-Item.\n4-Salir.\n");
            System.out.println("Ingrese la opcion que desea realizar: ");
            String op = keyboard.next();
            switch (op){
                case "1":
                    boolean salir1 = false;
                    while(!salir1){
                        System.out.println("\n1-Crear.\n2-Mostrar.\n3-Modificar.\n4-Eliminar:\n5-Atras.");
                        System.out.println("Ingrese la opcion que desea realizar sobre Clientes: ");
                        String op1 = keyboard.next();
                        switch (op1){
                            case "1":
                                //Crear
                                break;
                            case "2":
                                cliImp.mostrarPantalla();
                                break;
                            case "3":
                                //Modificar
                                break;
                            case "4":
                                cliImp.mostrarPantalla();
                                System.out.println("Ingrese el dni del Cliente que desea eliminar:");
                                Long toDelete = keyboard.nextLong();
                                cliImp.eliminar(toDelete);
                                break;
                            case "5":
                                salir1 = true;
                                break;
                            default:
                                System.out.println("Ingrese una opcion correcta!");
                                break;
                        }
                    }
                    break;
                case "2":
                    boolean salir2 = false;
                    while(!salir2){
                        System.out.println("\n1-Crear.\n2-Mostrar.\n3-Modificar.\n4-Eliminar:\n5-Atras.");
                        System.out.println("Ingrese la opcion que desea realizar sobre Facturas: ");
                        String op2 = keyboard.next();
                        switch (op2){
                            case "1":
                                //Crear
                                break;
                            case "2":
                                factImp.mostrarPantalla();
                                break;
                            case "3":
                                //Modificar
                                break;
                            case "4":
                                //Eliminar
                                break;
                            case "5":
                                salir2 = true;
                                break;
                            default:
                                System.out.println("Ingrese una opcion correcta!");
                                break;
                        }
                    }
                    break;
                case "3":
                    boolean salir3 = false;
                    while(!salir3){
                        System.out.println("\n1-Crear.\n2-Mostrar.\n3-Modificar.\n4-Eliminar:\n5-Atras.");
                        System.out.println("Ingrese la opcion que desea realizar sobre Items: ");
                        String op3 = keyboard.next();
                        switch (op3){
                            case "1":
                                //Crear
                                break;
                            case "2":
                                //Mostrar
                                break;
                            case "3":
                                //Modificar
                                break;
                            case "4":
                                //Eliminar
                                break;
                            case "5":
                                salir3 = true;
                                break;
                            default:
                                System.out.println("Ingrese una opcion correcta!");
                                break;
                        }
                    }
                    break;
                case "4":
                    System.out.println("Hasta la proxima!");
                    salir = true;
                    break;
                default:
                    System.out.println("Ingrese una opcion correcta!");
                    break;
            }
        }


    }
}

