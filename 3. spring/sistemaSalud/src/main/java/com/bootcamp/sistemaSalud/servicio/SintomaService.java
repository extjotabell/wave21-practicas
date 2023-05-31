package com.bootcamp.sistemaSalud.servicio;

import com.bootcamp.sistemaSalud.dto.SintomaDTO;
import com.bootcamp.sistemaSalud.entidades.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SintomaService {
    List<SintomaDTO> sintomas = new ArrayList<>();

    public SintomaService(){
        cargarSintomas();
    }
    public List<SintomaDTO> getAllSintoms(){
        //Busca en el repositorio toda la info y la guarda en una lista de dtos.
        return sintomas;
    }


    public void cargarSintomas(){
        sintomas.add(new SintomaDTO("001122","Malestar",4));
        sintomas.add(new SintomaDTO("001123","Dolor de Garganta",8));
        sintomas.add(new SintomaDTO("001124","Diarrea",8));
        sintomas.add(new SintomaDTO("001120","Tos",9));
        sintomas.add(new SintomaDTO("001125","Dificultad Respiratoria",10));
    }

    public String buscarNivelGravedadPorNombre(String nombre) {
        String nivel;
        for(SintomaDTO sin : sintomas){
            if(sin.getNombre().equals(nombre)){
                return String.valueOf(sin.getNivel_gravedad());
            }
        }
        return " ";
    //return sintomas.stream().filter(n -> n.getNombre().equals(nombre)).map(n->n.getNivel_gravedad()).toString();

    }


    }

