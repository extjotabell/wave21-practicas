package com.practicasIntegradoras.EdadPersona.controller;

import com.practicasIntegradoras.EdadPersona.service.Service;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/person")
public class Controller {

    Service service = new Service();
    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<Integer> age(@PathVariable Integer day,@PathVariable Integer month,@PathVariable Integer year){
        String date = year + "-" + month + "-" + day;
        Integer ageCalculated = service.calculateAge(date);
        return new ResponseEntity<>(ageCalculated, HttpStatus.OK);
    }
}
