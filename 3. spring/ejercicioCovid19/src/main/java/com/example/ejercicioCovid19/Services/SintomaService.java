package com.example.ejercicioCovid19.Services;

import com.example.ejercicioCovid19.Clases.Sintoma;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SintomaService {

    private static List<Sintoma> listaSintomas;


    public SintomaService() {
        this.listaSintomas = new ArrayList<>();
        Sintoma s1 = new Sintoma(1, "tos","leve" );
        Sintoma s2 = new Sintoma(2, "vomito", "alta");
        Sintoma s3 = new Sintoma(3, "convulsiones", "alta");
        listaSintomas.add(s1);
        listaSintomas.add(s2);
        listaSintomas.add(s3);

    }

    public List<Sintoma> findSymptom(){
        return listaSintomas;
    }

    public Sintoma findSymptomByName(String name){
        Sintoma sintomaEncontrado = null;

        for (Sintoma s : listaSintomas){
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
