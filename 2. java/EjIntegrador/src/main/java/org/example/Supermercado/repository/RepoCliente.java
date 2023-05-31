package org.example.Supermercado.repository;

import org.example.Supermercado.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepoCliente implements RepoCRUD <Cliente>{
    private List<Cliente> clientes = new ArrayList<>();

    public RepoCliente(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    public RepoCliente() {
    }

    public boolean buscarPorDNI(int dni){
        boolean encontrado =false;
        if (this.clientes != null){
        for ( int i=0; i<this.clientes.size(); i++) {
            if (this.clientes.get(i).getDni() == dni) {
                encontrado =true;
                System.out.println(this.clientes.get(i));
            }
        }}
        if (!encontrado){
            System.out.println("No se encuentra el DNI "+dni+" solicitado. Por favor, registre al nuevo cliente");
        }
        return encontrado;
    }

    public void imprimir(){
        for (int i= 0; i <this.clientes.size(); i++){
            System.out.println(this.clientes.get(i));
        }
    }

    @Override
    public void guardar(Cliente cliente) {
        if (buscarPorDNI(cliente.getDni())) {
            System.out.println("Ya existe el cliente de DNI"+ cliente.getDni());
        }
        this.clientes.add(cliente);
        System.out.println("Cliente ingresado con exito");
    }

    @Override
    public void eliminar(int dni) {
        if (buscarPorDNI(dni)) {
            int indiceEncontrado= 0;
            for (int i = 0; i < this.clientes.size(); i++) {
                if (this.clientes.get(i).getDni() == dni) {
                    System.out.println(this.clientes.get(i));
                    indiceEncontrado = i;
                }
            }
            clientes.remove(indiceEncontrado);
            System.out.println("Eliminado el cliente de DNI "+dni);
        } else {
            System.out.println("El cliente no existe");
        }
    }

    @Override
    public Optional buscarPorID(int dni) {
        boolean encontrado =false;
        if (this.clientes != null){
            for ( int i=0; i<this.clientes.size(); i++) {
                if (this.clientes.get(i).getDni() == dni) {
                    encontrado =true;
                    System.out.println(this.clientes.get(i));
                }
            }}
        if (!encontrado){
            System.out.println("No se encuentra el DNI "+dni+" solicitado. Por favor, registre al nuevo cliente");
        }
        return Optional.empty();
    }
};

