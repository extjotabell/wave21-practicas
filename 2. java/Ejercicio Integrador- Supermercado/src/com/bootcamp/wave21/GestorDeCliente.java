package com.bootcamp.wave21;

import java.util.HashMap;

public class GestorDeCliente {
    private HashMap<String,Cliente> clientes;

    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public boolean agregarCliente(Cliente cli){
     clientes.put(cli.getDni(),cli);
     return true;
    }

    public boolean elliminarCliente(String dni){
        if(clientes.get(dni) == null) {
            return false;
        }
        clientes.remove(dni);
        return true;
    }

    public Cliente buscarCliente(String dni){
        return clientes.get(dni);
    }

    public void imprimirClientes(){
        System.out.println("*****ESTADO ACTUAL DE LOS CLIENTES*****");
        System.out.println("\tDNI\t\tNOMBRE\t\tAPELLIDO");
        for (HashMap.Entry<String, Cliente> entry : this.getClientes().entrySet()) {
            System.out.println(entry.getValue().toString());
        }
    }
}
