package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RepoClientes {


    List<Cliente> clientes = new ArrayList<>();

    // esto es redundante, porque se puede buscar directamente en la lista cliente pero me parece más sencillo
    HashMap<String, List<Localizador>> dni_localizador = new HashMap<>();


    void guardarCliente(Cliente c) {
        clientes.add(c);
        dni_localizador.put(c.getDni(), c.getLocalizadores());
    }

    public double calcularDescuento(Cliente c) {
        return 0;
    }


}
