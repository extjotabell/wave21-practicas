package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")       //Define una ruta a éste controlador en la direccion /users/...
public class Controller {

    //localhost:8080/users...
    @GetMapping("/sayHello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping("/sayHelloToName/{name}")
    public String sayHelloToName(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/numerosRomanos/{decimal}")
    public String decimalToRoman(@PathVariable Integer decimal){
        String roman = "";
        String[] numerosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numerosDecimales = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int i = 0; i < numerosDecimales.length; i++){
            while (decimal >= numerosDecimales[i]) {
                roman += numerosRomanos[i];
                decimal -= numerosDecimales[i];
            }
        }
        return roman;
    }
}
