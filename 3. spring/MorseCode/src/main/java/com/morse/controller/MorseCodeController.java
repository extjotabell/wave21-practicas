package com.morse.controller;

import com.morse.service.MorseCodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("morse")
public class MorseCodeController {
    MorseCodeService morseCodeService;

    public MorseCodeController(MorseCodeService morseCodeService){
        this.morseCodeService = morseCodeService;
    }
    @GetMapping("/{phrase}")
    public String parse(@PathVariable String phrase){
        return this.morseCodeService.parse(phrase);
    }
}
