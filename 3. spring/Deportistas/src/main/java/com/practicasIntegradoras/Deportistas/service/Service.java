package com.practicasIntegradoras.Deportistas.service;

import com.practicasIntegradoras.Deportistas.dto.PersonSportDTO;
import com.practicasIntegradoras.Deportistas.entities.Person;
import com.practicasIntegradoras.Deportistas.entities.Sport;

import java.util.ArrayList;


public class Service {

    public ArrayList<Sport> sportsList = new ArrayList<>();
    public ArrayList<Person> personsList = new ArrayList<>();
    public ArrayList<PersonSportDTO> personSportDTOArrayList = new ArrayList<>();

    public Sport findSport(String name) {
        for (Sport sport : sportsList) {
            if (sport.getName().equals(name)) {
                return sport;
            }
        }
        return null;
    }

    public ArrayList<Sport> findSportList() {
        return sportsList;
    }

    public ArrayList<PersonSportDTO> personSportList() {
    return personSportDTOArrayList;
    }


}


