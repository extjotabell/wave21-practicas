package com.example.dto_response_entity_VIVO_p_2.repository;

import com.example.dto_response_entity_VIVO_p_2.dto.Response.ResponseDTO;
import com.example.dto_response_entity_VIVO_p_2.entity.Deporte;
import com.example.dto_response_entity_VIVO_p_2.entity.Persona;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@Repository
public class DeporteRepository implements IDeporteRepository {
    List<Deporte> deporteList = new ArrayList<>();
    Deporte deporte1 = new Deporte("Ciclismo", "High");
    Deporte deporte2 = new Deporte("Natacion", "Medium");
    Deporte deporte3 = new Deporte("Running", "Low");

    List<Persona> personaList = new ArrayList<>();
    Persona persona1 = new Persona("Pepe", "Pico", 22);
    Persona persona2 = new Persona("Pedro", "Pera", 34);
    Persona persona3 = new Persona("Pablo", "Poco", 65);

    List<ResponseDTO> responseDTOList = new ArrayList<>();
    ResponseDTO responseDTO1 = new ResponseDTO("Pepe", "Pico", deporte1);
    ResponseDTO responseDTO2 = new ResponseDTO("Pedro", "Pera", deporte2);
    ResponseDTO responseDTO3 = new ResponseDTO("Pablo", "Poco", deporte3);

    @Override
    public List<Deporte> getSport() {
        deporteList.add(deporte1);
        deporteList.add(deporte2);
        deporteList.add(deporte3);

        return deporteList;
    }

    @Override
    public String getByName(String name) {
        Deporte depor = deporteList.stream()
                .filter(n -> n.getNombre().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);

        return depor.getNivel();
    }

    @Override
    public List<ResponseDTO> getSportsByPerson() {
        responseDTOList.add(responseDTO1);
        responseDTOList.add(responseDTO2);
        responseDTOList.add(responseDTO3);

        List<ResponseDTO> respo =  responseDTOList.stream()
                .map(m -> new ResponseDTO(
                        m.getNombre(),
                        m.getApellido(),
                        m.getDeporte()
                ))
                .toList();
        return respo;
    }

}
