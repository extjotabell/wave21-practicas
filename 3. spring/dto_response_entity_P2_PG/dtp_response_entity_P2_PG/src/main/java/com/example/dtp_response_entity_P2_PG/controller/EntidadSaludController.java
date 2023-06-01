package com.example.dtp_response_entity_P2_PG.controller;

import com.example.dtp_response_entity_P2_PG.dto.GrupoDeRiesgoDTO;
import com.example.dtp_response_entity_P2_PG.dto.PersonasDTO;
import com.example.dtp_response_entity_P2_PG.dto.SintomasDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@RestController
@RequestMapping("/")
public class EntidadSaludController {
    List<PersonasDTO> personasDTOList = new ArrayList<>();
    List<SintomasDTO> sintomasDTOList = new ArrayList<>();
    List<GrupoDeRiesgoDTO> grupoDeRiesgoDTOList = new ArrayList<>();


    public EntidadSaludController() {

        PersonasDTO personasDTO1 = new PersonasDTO(1, "Pepe", "Pico", 65);
        PersonasDTO personasDTO2 = new PersonasDTO(2, "Pedro", "Piso", 23);
        PersonasDTO personasDTO3 = new PersonasDTO(3, "Pablo", "Pesa", 35);

        personasDTOList.add(personasDTO1);
        personasDTOList.add(personasDTO2);
        personasDTOList.add(personasDTO3);

        SintomasDTO sintomasDTO1 = new SintomasDTO("A1", "Gripe", "Low");
        SintomasDTO sintomasDTO2 = new SintomasDTO("B1", "Sinusitis", "Medium");
        SintomasDTO sintomasDTO3 = new SintomasDTO("C1", "Dolor de Garganta", "High");

        sintomasDTOList.add(sintomasDTO1);
        sintomasDTOList.add(sintomasDTO2);
        sintomasDTOList.add(sintomasDTO3);

        grupoDeRiesgoDTOList.add(new GrupoDeRiesgoDTO(personasDTO1, Arrays.asList(sintomasDTO1, sintomasDTO2)));
        grupoDeRiesgoDTOList.add(new GrupoDeRiesgoDTO(personasDTO2, Arrays.asList()));
        grupoDeRiesgoDTOList.add(new GrupoDeRiesgoDTO(personasDTO3, Arrays.asList(sintomasDTO3, sintomasDTO1)));
    }

    @GetMapping("findSymptom")
    public List<SintomasDTO> getAllSymptom() {
        return sintomasDTOList;
    }

    @GetMapping("findSymptom/{name}")
    ResponseEntity<String> getSymptomByName(@PathVariable String name) {

        boolean exist = false;
        String gravedadSintoma = "";
        for (int i=0; i < sintomasDTOList.size(); i++) {
            if (name.equals(sintomasDTOList.get(i).getNombre())) {
                exist = true;
                gravedadSintoma = sintomasDTOList.get(i).getNivelDeGravedad();
            }
        }
        if (exist) {
            return new ResponseEntity<String>(gravedadSintoma, HttpStatus.OK);
        } else {
            return new ResponseEntity<String>("Symptom Not Found", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("findRiskPerson")
    ResponseEntity<String> getRiskPerson() {

        for (int i=0; i< grupoDeRiesgoDTOList.size(); i++) {
            Integer edadDeRiesgo = grupoDeRiesgoDTOList.get(i).getPersona().getEdad();
            Integer haySintomas = grupoDeRiesgoDTOList.get(i).getSintoma().size();
            String nombreRiesgo = grupoDeRiesgoDTOList.get(i).getPersona().getNombre();
            String apellidoReisgo = grupoDeRiesgoDTOList.get(i).getPersona().getApellido();

            if ( edadDeRiesgo >= 60 && haySintomas >= 1) {
                return new ResponseEntity<String>("Nombre: " + nombreRiesgo + " Apellido: " + apellidoReisgo, HttpStatus.OK);
            }
        }
        return new ResponseEntity<String>("No hay pacientes", HttpStatus.NOT_FOUND);
    }
}
