package com.codemorse.codemorse.Controllers;

import com.codemorse.codemorse.Services.ConvertMorse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConvertMorseController {
    @GetMapping("/{code}")
    public String convertMorse(@PathVariable String code){
        ConvertMorse convertMorse = new ConvertMorse();
        return convertMorse.convertToMorse(code);
    }
}
