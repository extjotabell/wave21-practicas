package com.example.ejercicioDeportistasDTO.Repository;

import com.example.ejercicioDeportistasDTO.Clases.Deporte;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioDeportes {
    List<Deporte> listaDeportes = new ArrayList<>();

    public RepositorioDeportes(List<Deporte> listaDeportes) {
        this.listaDeportes = listaDeportes;
    }
    public RepositorioDeportes() {
        Deporte d1 = new Deporte("Futbol", "Facil");
        Deporte d2 = new Deporte("Voley", "Moderado");
        Deporte d3 = new Deporte("Ping Pong", "Dificil");
        Deporte d4 = new Deporte("Softball", "Dificil");
        this.listaDeportes.add(d1);
        this.listaDeportes.add(d2);
        this.listaDeportes.add(d3);
        this.listaDeportes.add(d4);

    }

    public List<Deporte> getListaDeportes() {
        return listaDeportes;
    }

    public void setListaDeportes(List<Deporte> listaDeportes) {
        this.listaDeportes = listaDeportes;
    }

    public void addDeporte(Deporte unDeporte){
        this.listaDeportes.add(unDeporte);
    }

}
