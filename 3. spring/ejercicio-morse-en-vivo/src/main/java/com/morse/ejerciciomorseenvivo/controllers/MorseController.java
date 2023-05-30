package com.morse.ejerciciomorseenvivo.controllers;

import com.morse.ejerciciomorseenvivo.services.MorseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ejercicio/morse")
public class MorseController {

    @GetMapping("/{clave}")
    public String getPhraseByMorse(@PathVariable String clave){
        return MorseService.getPhrase(clave);
    }
}
