package com.bootcamp.wave21;

import com.bootcamp.wave21.model.Cliente;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class RepositorioDeCliente implements Repositorio {
    private HashMap<String, Cliente> clientes;

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean elliminarCliente(String dni){
        if(clientes.get(dni) == null) {
            return false;
        }
        clientes.remove(dni);
        return true;
    }



    public void imprimirClientes(){
        System.out.println("*****ESTADO ACTUAL DE LOS CLIENTES*****");
        System.out.println("\tDNI\t\tNOMBRE\t\tAPELLIDO");
        for(Cliente cli : buscarTodos()){
            System.out.println(cli.toString());
        }

    }

    public void menuGestorCliente(){
        Scanner ingresoTeclado = new Scanner(System.in);
        int menu = 0;
        while(menu != 4){
            System.out.println("\n\n\n\n*******BIENVENIDOS AL GESTOR DE CLIENTES********\n\n\n");
            System.out.println("0.- Crear Cliente\n1.- Buscar Cliente\n2.- Eliminar Cliente\n3.- Imprimir \n4.- Salir>:");
            menu = ingresoTeclado.nextInt();
            ingresoTeclado.nextLine();
            String docu = "";
            Cliente resultado;
            switch (menu){
                case 1 :
                    System.out.println("Ingrese DNI DEl cliente: ");
                    docu = ingresoTeclado.nextLine();
                    resultado = this.buscar(docu);
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
                    if(!this.elliminarCliente(docu)){
                        System.out.println("Ese cliente no se encuentra registrado en la BBDD");
                    }else{
                        System.out.println("****USUARIO ELIMINADO******");
                    }
                    break;
                case 3 :

                    this.imprimirClientes();
                    break;
                case 0 :
                    System.out.println("Ingrese DNI: ");
                    docu = ingresoTeclado.nextLine();
                    if(this.buscar(docu) != null){
                        System.out.println("Usuario ya creado");

                    }else{
                        resultado = new Cliente();
                        resultado.setDni(docu);
                        System.out.println("Ingrese Nombre");
                        resultado.setNombre(ingresoTeclado.nextLine());
                        System.out.println("Ingrese Apellido");
                        resultado.setApellido(ingresoTeclado.nextLine());
                        this.agregar(resultado);
                        System.out.println("Cliente agregado3");
                    }

            }


        }
        System.out.println("\n\n\n\n*******MUCHAS GRACIAS*******\n\n\n");

    }

    @Override
    public Cliente buscar(Object cli) {
        Cliente cliente = (Cliente) cli;
        return clientes.get(cliente.getDni());
    }

    @Override
    public boolean agregar(Object cli) {
        Cliente cliente = (Cliente) cli;
        clientes.put(cliente.getDni(),cliente);
        return true;
    }

    @Override
    public boolean eliminar(Object obj) {
        Cliente cli = (Cliente) obj;
        if(buscar(cli.getDni()) == null){
            return false;
        }
        clientes.remove(cli.getDni());
        return true;
    }

    @Override
    public List<Cliente> buscarTodos() {
        List<Cliente> todos = new ArrayList<>();
        for (HashMap.Entry<String, Cliente> entry : this.getClientes().entrySet()) {
            todos.add(new Cliente(entry.getValue().getDni(),entry.getValue().getNombre(),entry.getValue().getApellido()));
        }
        return todos;
    }
}


