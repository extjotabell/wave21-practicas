package org.example.supermercado.repository;

import org.example.supermercado.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUD<Cliente> {
    List<Cliente> clienteList = new ArrayList<>();

    @Override
    public void guardar(Cliente objeto) {
        clienteList.add(objeto);
    }

    @Override
    public void imprimirPantalla() {
        clienteList.forEach(System.out::println);
    }

    @Override
    public Optional<Cliente> buscar(String id) {
        Cliente clienteBuscado = null;

        for (Cliente cliente : clienteList) {
            if (cliente.getDni().equals(id)) {
                clienteBuscado = cliente;
            }
        }

        if (clienteBuscado == null) {
            System.out.println("No se encontro cliente con DNI: " + id);
            return Optional.empty();
        } else {
            return Optional.of(clienteBuscado);
        }
    }

    @Override
    public void eliminar(String id) {
        Optional<Cliente> clienteABorrar = this.buscar(id);
        if(clienteABorrar.isPresent()) clienteList.remove(clienteABorrar.get());
    }

    @Override
    public List<Cliente> buscarTodos() {
        return null;
    }
}
