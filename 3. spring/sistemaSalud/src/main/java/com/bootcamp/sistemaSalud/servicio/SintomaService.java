package com.bootcamp.sistemaSalud.servicio;

import com.bootcamp.sistemaSalud.dto.SintomaDTO;
import com.bootcamp.sistemaSalud.entidades.Sintoma;
import com.bootcamp.sistemaSalud.repository.SymptomRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SintomaService {
@Autowired
SymptomRepo repo;

    public SintomaService(SymptomRepo repo){
        this.repo = repo;
    }

    public List<SintomaDTO> getAllSintoms(){
        //Busca en el repositorio toda la info y la guarda en una lista de dtos.
        List<SintomaDTO> sintomasConvert = new ArrayList<>();

        for(Sintoma sin : repo.getSintomas()){

            sintomasConvert.add(new SintomaDTO(sin.getNombre(),sin.getCodigo(),sin.getNivel_de_gravedad()));
        }
        return sintomasConvert  ;
    }


    public String buscarNivelGravedadPorNombre(String nombre) {
        String nivel;
        for(Sintoma sin : repo.getSintomas()){
            if(sin.getNombre().equals(nombre)){
              return String.valueOf(sin.getNivel_de_gravedad());
            }
        }
        return " ";
    //return sintomas.stream().filter(n -> n.getNombre().equals(nombre)).map(n->n.getNivel_gravedad()).toString();

    }


    }

