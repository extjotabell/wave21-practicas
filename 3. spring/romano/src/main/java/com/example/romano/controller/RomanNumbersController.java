package com.example.romano.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import com.example.romano.service.RomanNumbersImp;
@RestController
public class RomanNumbersController {
    @GetMapping
    public String sayHello(){
        return "Hello";
    }
    @GetMapping("/romano/{num}")
    public String getRomanNumberByDecimalNumber(@PathVariable Integer num){
        RomanNumbersImp romanNumbersImp = new RomanNumbersImp();
        return romanNumbersImp.convertToRomanNumber(num);
    }
}
