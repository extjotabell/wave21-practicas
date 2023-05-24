package com.bootcamp.wave21;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
        GestorDeCliente gestionCliente = new GestorDeCliente();
        Scanner ingresoTeclado = new Scanner(System.in);
        int menu = 0;

        for(int i = 0 ; i < 3 ; i ++){
            clientes.put("3334499"+i,new Cliente("3334499"+i,"Juan"+i,"Martin"+i));
        }
        gestionCliente.setClientes(clientes);


        while(menu != 4){
        System.out.println("\n\n\n\n*******BIENVENIDOS AL GESTOR DE CLIENTES********\n\n\n");
        System.out.println("0,- Crear Cliente≤\n1.- Buscar Cliente\n2.- Eliminar Cliente\n3.- Imprimir \n 4.- Salir>:");
        menu = ingresoTeclado.nextInt();
        ingresoTeclado.nextLine();
        String docu = "";
        Cliente resultado;
        switch (menu){
            case 1 :
                System.out.println("Ingrese DNI DEl cliente: ");
                docu = ingresoTeclado.nextLine();
                resultado = gestionCliente.buscarCliente(docu);
                if(resultado == null){
                    System.out.println("Ese cliente no se encuentra registrado en la BBDD");
                }else{
                    System.out.println("****USUARIO ENCONTRADO******");
                    System.out.println(resultado.toString());

                }
                break;
            case 2 :

                System.out.println("Ingrese DNI DEl cliente a eliminar: ");
                docu = ingresoTeclado.nextLine();
                if(!gestionCliente.elliminarCliente(docu)){
                    System.out.println("Ese cliente no se encuentra registrado en la BBDD");
                }else{
                    System.out.println("****USUARIO ELIMINADO******");
                }
                break;
            case 3 :
                    gestionCliente.imprimirClientes();
                break;
            case 0 :
                System.out.println("Ingrese DNI: ");
                docu = ingresoTeclado.nextLine();
                if(gestionCliente.buscarCliente(docu) != null){
                    System.out.println("Usuario ya creado");

                }else{
                    resultado = new Cliente();
                    resultado.setDni(docu);
                    System.out.println("Ingrese Nombre");
                    resultado.setNombre(ingresoTeclado.nextLine());
                    System.out.println("Ingrese Apellido");
                    resultado.setApellido(ingresoTeclado.nextLine());
                    gestionCliente.agregarCliente(resultado);
                    System.out.println("Cliente agregado3");
                }

        }


        }
        System.out.println("\n\n\n\n*******MUCHAS GRACIAS*******\n\n\n");

    }
}
