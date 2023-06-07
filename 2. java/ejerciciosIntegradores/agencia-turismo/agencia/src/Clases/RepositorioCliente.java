package Clases;

import Interfaces.Repositorio;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente implements Repositorio<Cliente> {
    private List<Cliente> clientes = new ArrayList<>();

    @Override
    public void agregar(Cliente cliente) {
        clientes.add(cliente);
    }

    @Override
    public Cliente buscarPorId(String id) {
        for(Cliente cliente : clientes){
            if (cliente.getId().equals(id)){
                return cliente;
            }
        }
        return null;
    }

    @Override
    public List<Cliente> obtenerTodos() {
        return new ArrayList<>(clientes);
    }
}
