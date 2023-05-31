package com.example_morsaa.morsaa;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorseController {

    private final MorseService morseService;

    public MorseController(MorseService morseService) {
        this.morseService = morseService;
    }

    @PostMapping("/translate")
    public String translate(@RequestBody Message reqBody) {
        //System.out.println("reqBody");
        //System.out.println(reqBody.message);
        return morseService.translateToMorse(reqBody.message);
    }
}
