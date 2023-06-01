package com.practicasIntegradoras.Deportistas.controller;

import com.practicasIntegradoras.Deportistas.dto.PersonSportDTO;
import com.practicasIntegradoras.Deportistas.entities.Person;
import com.practicasIntegradoras.Deportistas.entities.Sport;
import com.practicasIntegradoras.Deportistas.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/sports")
public class Controller {

    Service service = new Service();

    @GetMapping("cargarDatos")
    public void cargarDatos(){
        Sport sport1 = new Sport("Tenis", 1);
        Sport sport2 = new Sport("Futbol", 2);
        Sport sport3 = new Sport("Basket", 3);
        Person person1 = new Person("Juan", "Suarez", 25,sport1);
        Person person2 = new Person("Perdo", "Martinez", 18,sport2);
        Person person3 = new Person("Martin", "Diaz", 35,sport3);
        service.personsList.add(person1);
        service.personsList.add(person2);
        service.personsList.add(person3);
        service.sportsList.add(sport1);
        service.sportsList.add(sport2);
        service.sportsList.add(sport3);

        PersonSportDTO personSportDTO1 = new PersonSportDTO(person1.getName(),person1.getSurname(),sport1.getName());
        PersonSportDTO personSportDTO2 = new PersonSportDTO(person2.getName(),person2.getSurname(),sport2.getName());
        PersonSportDTO personSportDTO3 = new PersonSportDTO(person3.getName(),person3.getSurname(),sport3.getName());
        service.personSportDTOArrayList.add(personSportDTO1);
        service.personSportDTOArrayList.add(personSportDTO2);
        service.personSportDTOArrayList.add(personSportDTO3);
    }

    @GetMapping("/findSports")
    public ResponseEntity<ArrayList<Sport>> findSports(){
        ArrayList<Sport> sportsList = service.findSportList();
        return new ResponseEntity<>(sportsList, HttpStatus.OK);
    }
    @GetMapping("findSports/{name}")
    public ResponseEntity<String> findSports(@PathVariable String name){
        Sport sport = service.findSport(name);
        String level = "";
        if(sport != null){
            level = "Nivel: " + sport.getLevel();
        }
        else{
            level= "No existe deporte";
        }
        return new ResponseEntity<>(level, HttpStatus.OK);
    }

    @GetMapping("findSportsPerson")
    public ResponseEntity<ArrayList<PersonSportDTO>> findSportsPerson(){
        ArrayList<PersonSportDTO> personSportDTOArrayList = service.personSportList();

        return new ResponseEntity<>( personSportDTOArrayList, HttpStatus.OK);
    }
}
