package org.parteI.logic;

import org.parteI.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class crudCliente implements iCrudCliente {
    List<Cliente> clienteList = new ArrayList<>();

    @Override
    public void crearCliente(long dni, String nombre, String apellido) {
        clienteList.add(new Cliente(dni, nombre, apellido));
        System.out.println("Se creo el cliente con el dni: " + dni);
    }

    @Override
    public List<Cliente> consultarClientes() {

        return clienteList;
    }

    @Override
    public List<Cliente> consultarClientes(long dni) {

        List<Cliente> listaResultado = clienteList.stream().filter(item -> item.getDni() == dni).toList();


        return listaResultado;
    }

    @Override
    public void eliminarCliente(long dni) {

        Optional<Cliente> clienteEli = clienteList.stream().filter(item -> item.getDni() == dni).findFirst();
        if (clienteEli.isPresent()) {
            clienteList.remove(clienteEli.get());
            System.out.println("El cliente con Dni: " + dni + " se elimino correctamnete!!");
            System.out.println("Lista de clientes actualizada");
            consultarClientes();
        } else {
            System.out.println("El cliente con Dni: " + dni + " no existe!!");
        }

    }

    @Override
    public void actualizarCliente(long dni, String nombre, String apellido) {

       clienteList.stream().filter(item -> item.getDni() == dni).toList().forEach(item -> {
            item.setNombre(nombre.equals(item.getNombre()) ? item.getNombre() : nombre);
            item.setApellido(apellido.equals(item.getApellido()) ? item.getApellido() : apellido);
        });

    }

    public void imprimirClientes(List<Cliente> clienteListFinal) {

        if (clienteListFinal.size() > 0) {
            clienteListFinal.forEach(item -> {
                System.out.println(item.toString());
            });
        } else {
            System.out.println("El cliente no existe!!");
        }
    }
}
