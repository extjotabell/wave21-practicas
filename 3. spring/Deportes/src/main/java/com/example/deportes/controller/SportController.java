package com.example.deportes.controller;

import com.example.deportes.clase.Sport;
import com.example.deportes.clase.SportPerson;
import com.example.deportes.dto.SportDTO;
import com.example.deportes.dto.SportPersonDTO;
import com.example.deportes.service.SportService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("sport")
public class SportController {
    private SportService sportService;

    @Autowired
    private ModelMapper modelMapper;

    public SportController(SportService sportService){
        this.sportService = sportService;
    }
    @GetMapping("findSports")
    public ResponseEntity<List<SportDTO>> findSports(){
        List<Sport> sports = sportService.findSports();
        return sports.isEmpty() ? ResponseEntity.badRequest().body(null) : ResponseEntity.ok(sports.stream().map(this::convertToDto).collect(Collectors.toList()));
    }

    @GetMapping("findSport/{name}")
    public ResponseEntity<SportDTO> findSport(@PathVariable String name){
        Sport sport = sportService.findSport(name);
        return sport == null ? ResponseEntity.badRequest().body(null) : ResponseEntity.ok(convertToDto(sport));
    }

    @GetMapping("findSportsPersons")
    public ResponseEntity<List<SportPersonDTO>> findSportPersons(){
        List<SportPerson> sportPersons = sportService.findSportPersons();
        return sportPersons.isEmpty() ? ResponseEntity.badRequest().body(null) : ResponseEntity.ok(sportPersons.stream().map(this::convertToDto).collect(Collectors.toList()));
    }



    private SportDTO convertToDto(Sport sport) {
        return sport == null ? null : modelMapper.map(sport, SportDTO.class);
    }

    private SportPersonDTO convertToDto(SportPerson sportPerson){
        return sportPerson == null ? null : modelMapper.map(sportPerson, SportPersonDTO.class);
    }
}
