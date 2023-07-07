package com.hql.ej1.controller;

import com.hql.ej1.model.Serie;
import com.hql.ej1.service.SerieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/serie")
public class SerieController {

    SerieService serieService;

    public SerieController(SerieService serieService){
        this.serieService=serieService;
    }

    @GetMapping("/{number}")
    public List<Serie> getAllByNumberOfSeries(@PathVariable Integer number){
        return serieService.getAllByNumberOfSeasons(number);
    }
}
