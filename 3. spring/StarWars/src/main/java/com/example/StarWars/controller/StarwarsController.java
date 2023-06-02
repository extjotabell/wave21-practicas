package com.example.StarWars.controller;

import com.example.StarWars.dto.PersonajeDto;
import com.example.StarWars.dto.response.PersonajeResponseDto;
import com.example.StarWars.service.StarwarsService;
import com.example.StarWars.service.StarwarsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarwarsController {
    @Autowired(required = true)
    StarwarsService starwarsServiceImpl;
    @GetMapping("")
    public ResponseEntity<List<PersonajeDto>> findAll(){
        return null;
    }
    @PostMapping("/save")
    public ResponseEntity<String> saveList(@RequestBody ArrayList<PersonajeDto> list){
        String res = starwarsServiceImpl.saveAll(list);
        if(res != null)
            return ResponseEntity.ok(res);
        else
            return new ResponseEntity("Ocurrio un problema", HttpStatus.CONFLICT);
    }
    @GetMapping("/find/{name}")
    public ResponseEntity<List<PersonajeResponseDto>> findPlayer(@PathVariable String name){
        List<PersonajeResponseDto> res = starwarsServiceImpl.findByName(name);
        return ResponseEntity.ok(res);
    }
}
