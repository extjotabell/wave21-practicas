package com.example.ejercicioDeportistasDTO.Repository;

import com.example.ejercicioDeportistasDTO.Clases.Deporte;
import com.example.ejercicioDeportistasDTO.Clases.Persona;

import java.util.ArrayList;
import java.util.List;

public class RepositorioPersonas {
    List<Persona> listaPersonas = new ArrayList<>();

    public RepositorioPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }
    public RepositorioPersonas(){
        Deporte d1 = new Deporte("Futbol", "Facil");
        Deporte d2 = new Deporte("Voley", "Moderado");
        Deporte d3 = new Deporte("Ping Pong", "Dificil");
        Deporte d4 = new Deporte("Softball", "Dificil");

        Persona p1 = new Persona("Gabriel", "Antonietti", 35, d1);
        Persona p2 = new Persona("Evelin", "Martinez", 26, d2);
        Persona p3 = new Persona("Maria", "Samaniego", 40, d3);
        Persona p4 = new Persona("Nicolas", "Pereira", 45);
        Persona p5 = new Persona("Tomas", "Pacheco", 18);
        Persona p6 = new Persona("Giovanni", "Catoreti", 21, d4);

        this.listaPersonas.add(p1);
        this.listaPersonas.add(p2);
        this.listaPersonas.add(p3);
        this.listaPersonas.add(p4);
        this.listaPersonas.add(p5);
        this.listaPersonas.add(p6);
    }

    public List<Persona> getListaPersonas() {
        return listaPersonas;
    }

    public void setListaPersonas(List<Persona> listaPersonas) {
        this.listaPersonas = listaPersonas;
    }

}
