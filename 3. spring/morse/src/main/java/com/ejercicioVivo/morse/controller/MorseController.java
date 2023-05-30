package com.ejercicioVivo.morse.controller;

import com.ejercicioVivo.morse.service.Morse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    @GetMapping("/{morse}")
    public String morseAtexto (@PathVariable String morse){
        return Morse.transformarAtexto(morse);
    }
}
