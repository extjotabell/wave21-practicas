package com.bootcamp.wave21;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GestorCliente {
    private RepositorioCliente repoCliente;
    private RepositorioLocalizador repoLoca;

    public GestorCliente(RepositorioCliente repoCliente, RepositorioLocalizador repoLoca) {
        this.repoCliente = repoCliente;
        this.repoLoca = repoLoca;
    }

    public List<Localizador> buscarLocalizadoresPorCliente(String dni){

        List<Localizador> resultado = new ArrayList<>();
        if (!repoCliente.esClienteRegistrado(dni)){
            System.out.println("USuario no registrado.");
            return resultado;
        }

        resultado = this.repoLoca.getLocalizadores().stream()
                .filter(c->c.getCliente().getDni() == dni)
                .collect(Collectors.toList());
        return resultado;
    }


    public RepositorioCliente getRepoCliente() {
        return repoCliente;
    }

    public void setRepoCliente(RepositorioCliente repoCliente) {
        this.repoCliente = repoCliente;
    }

    public RepositorioLocalizador getRepoLoca() {
        return repoLoca;
    }

    public void setRepoLoca(RepositorioLocalizador repoLoca) {
        this.repoLoca = repoLoca;
    }

    public int cantidadLocalizadoresVendidos(){

        return this.getRepoLoca().getLocalizadores().size();
    }
    public int cantidadTotalDeReservas() {
        int total = 0;

        for (Localizador loc : this.getRepoLoca().getLocalizadores()) {

            total += loc.getPaquetes().size();
        }
        return total;
    }

    public double totalVentas(){

        return this.getRepoLoca().getLocalizadores().stream().mapToDouble(n->n.getMontoTotal()).sum();
    }
}
