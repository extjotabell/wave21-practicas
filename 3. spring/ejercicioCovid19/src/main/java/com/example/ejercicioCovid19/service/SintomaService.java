package com.example.ejercicioCovid19.service;

import com.example.ejercicioCovid19.dto.SintomaDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SintomaService {

    private static List<SintomaDTO> listaSintomas;


    public SintomaService() {
        this.listaSintomas = new ArrayList<>();
        SintomaDTO s1 = new SintomaDTO(1, "tos","leve" );
        SintomaDTO s2 = new SintomaDTO(2, "vomito", "alta");
        SintomaDTO s3 = new SintomaDTO(3, "convulsiones", "alta");
        listaSintomas.add(s1);
        listaSintomas.add(s2);
        listaSintomas.add(s3);

    }

    public List<SintomaDTO> findSymptom(){
        return listaSintomas;
    }

    public SintomaDTO findSymptomByName(String name){
        SintomaDTO sintomaEncontrado = null;

        for (SintomaDTO s : listaSintomas){
            if(s.getNombre().equals(name)){
                sintomaEncontrado = s;
                break;
            }
        }
            /*
            Sintoma sintomaFound = this.listaSintomas.stream()
                    .filter(sintoma -> sintoma.getNombre().equals(name));
            */

        return sintomaEncontrado;
    }


}
