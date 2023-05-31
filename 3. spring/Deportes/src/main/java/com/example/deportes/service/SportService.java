package com.example.deportes.service;

import com.example.deportes.clase.Sport;
import com.example.deportes.clase.SportPerson;
import com.example.deportes.dto.SportDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SportService {
    public static List<Sport> sports = new ArrayList<>();
    public static List<SportPerson> sportPersons = new ArrayList<>();
    public List<Sport> findSports(){
        return this.sports;
    }

    public Sport findSport(String name){
        return this.sports
                .stream()
                .filter(sport -> sport.getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public List<SportPerson> findSportPersons(){
        return this.sportPersons;
    }
}
