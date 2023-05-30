package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Controller {
    @GetMapping("/sayHello")
    public String sayHello(){
        return "Hello World";
    }

    @GetMapping("/sayName/{name}")
    public String sayHello(@PathVariable String name){
        return "Hello " + name;
    }
}
