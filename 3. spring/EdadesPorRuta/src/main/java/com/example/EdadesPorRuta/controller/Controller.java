package com.example.EdadesPorRuta.controller;


import com.example.EdadesPorRuta.service.ServiceAge;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController()
public class Controller {

    @Autowired
    ServiceAge serviceAge;
    @GetMapping("/{day}/{month}/{year}")
    public ResponseEntity<?> calculateAge(@PathVariable String day, @PathVariable String month,
                                          @PathVariable String year){

        ResponseEntity<?> edad = serviceAge.calculateAge(day, month, year);

        return edad;
    }
}
