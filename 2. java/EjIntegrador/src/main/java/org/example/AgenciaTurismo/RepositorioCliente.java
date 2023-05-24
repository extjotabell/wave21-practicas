package org.example.AgenciaTurismo;

import java.util.List;

public class RepositorioCliente {

    private Cliente cliente;
    private List<Localizador> localizadores;

    public RepositorioCliente(Cliente cliente, List<Localizador> localizadores) {
        this.cliente = cliente;
        this.localizadores = localizadores;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }
    
}
