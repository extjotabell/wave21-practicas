package com.bootcamp.sistemaSalud.repository;

import com.bootcamp.sistemaSalud.dto.SintomaDTO;
import com.bootcamp.sistemaSalud.entidades.Persona;
import com.bootcamp.sistemaSalud.entidades.Sintoma;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SymptomRepo {
    List<Persona> personas ;
    List<Sintoma> sintomas;

    public SymptomRepo(){
        personas = new ArrayList<>();
        sintomas = new ArrayList<>();
        cargarSintomas();
        cargarPersonas();
    }

    public List<Persona> getPersonas(){
        return  this.personas;
    }

    public List<Sintoma> getSintomas(){
        return this.sintomas;
    }

    public void cargarPersonas(){

        personas.add(new Persona(1,"Juan","Mora",35));
        personas.add(new Persona(2,"Ramiro","Puerta",70));
        personas.add(new Persona(3,"Pedro","Escamoso",53));
        personas.get(0).agregarSintoma(new Sintoma("001125","Dificultad Respiratoria",10));
        personas.get(0).agregarSintoma(new Sintoma("001124","Diarrea",8));
        personas.get(1).agregarSintoma(new Sintoma("001125","Dificultad Respiratoria",10));
        personas.get(1).agregarSintoma(new Sintoma("001124","Diarrea",8));
        personas.get(2).agregarSintoma(new Sintoma("001125","Dificultad Respiratoria",10));
        personas.get(2).agregarSintoma(new Sintoma("001124","Diarrea",8));

    }

    public void cargarSintomas(){
        sintomas.add(new Sintoma("001122","Malestar",4));
        sintomas.add(new Sintoma("001123","Dolor de Garganta",8));
        sintomas.add(new Sintoma("001124","Diarrea",8));
        sintomas.add(new Sintoma("001120","Tos",9));
        sintomas.add(new Sintoma("001125","Dificultad Respiratoria",10));
    }
}
