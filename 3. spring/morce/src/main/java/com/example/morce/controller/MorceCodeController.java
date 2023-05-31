package com.example.morce.controller;

import com.example.morce.service.MorceCodeImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MorceCodeController {
    @GetMapping("/morce/{code}")
    public String getMorceCode(@PathVariable String code){
        MorceCodeImpl morceCode = new MorceCodeImpl();
        return morceCode.convertToMorceCode(code);
    }
}
