package com.example.ejerciciopersonajesstarwarsenvivoypg.controller;

import com.example.ejerciciopersonajesstarwarsenvivoypg.service.StarWarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class StarWarsController {

    @Autowired
    StarWarsService starWarsService;

    @GetMapping("artists/{name}")
    public ResponseEntity<?> getArtistsByName(@PathVariable String name){
        return starWarsService.artistsByName(name);
    }
}
