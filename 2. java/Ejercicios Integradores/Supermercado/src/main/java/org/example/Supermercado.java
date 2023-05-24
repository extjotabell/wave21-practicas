package org.example;


import java.util.ArrayList;
import java.util.Optional;

public class Supermercado {

    private ArrayList<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(Cliente c) {
        clientes.add(c);
    }

    public void mostrarClientes(){
        clientes.forEach(c -> c.mostrarDatos());
    }

    public void eliminarCliente(Cliente c) {
        clientes.remove(c);
    }

    public Optional<Cliente> dniEsCliente(String dni) {
        return clientes.stream().filter(c-> c.getDni() == dni).findAny();

    }
}
