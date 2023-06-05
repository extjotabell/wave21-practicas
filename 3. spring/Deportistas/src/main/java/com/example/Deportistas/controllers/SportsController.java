package com.example.Deportistas.controllers;

import com.example.Deportistas.dto.Deporte;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sports")
public class SportsController {

    @RequestMapping("/findSports")
    public List<Deporte> getSports() {
        return null;
    }


    @RequestMapping("/findSsport/{name}")
    public Deporte getSportByName() {
        return null;
    }

}
