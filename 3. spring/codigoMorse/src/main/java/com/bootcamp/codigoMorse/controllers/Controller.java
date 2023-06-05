package com.bootcamp.codigoMorse.controllers;

import com.bootcamp.codigoMorse.services.MorseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @Autowired
    MorseService morseService;

    @GetMapping("/parser/{morseCode}")
    public String parseMorseToSpanish(@PathVariable String morseCode) {
        return morseService.parseMorse(morseCode);
    }
}
