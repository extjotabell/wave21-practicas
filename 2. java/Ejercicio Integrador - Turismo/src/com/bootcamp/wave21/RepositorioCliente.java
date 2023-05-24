package com.bootcamp.wave21;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioCliente {

   private HashMap<String, Cliente> clientes;


    public RepositorioCliente() {
        clientes = new HashMap<>();
    }

    public void agregarCliente(Cliente cli){

        this.getClientes().put(cli.getDni(),cli);
    }

    public void eliminarCliente(String dni){
        this.getClientes().remove(dni);

    }

    public  boolean esClienteRegistrado(String dni){

        return this.getClientes().get(dni) != null;
    }



    public HashMap<String, Cliente> getClientes() {
        return clientes;
    }


    public void setClientes(HashMap<String, Cliente> clientes) {
        this.clientes = clientes;
    }


}
