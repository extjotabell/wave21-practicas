package org.parteI.logic;

import org.parteI.model.Cliente;

import java.util.List;

public interface iCrudCliente {
    void crearCliente(long dni, String nombre, String apellido);
    List<Cliente> consultarClientes();
    List<Cliente>  consultarClientes(long dni);
    void eliminarCliente(long dni);
    void actualizarCliente(long dni, String nombre, String apellido);
    void imprimirClientes(List<Cliente> clienteListFinal);

}
