package com.roman.numerals.controller;

import com.roman.numerals.service.ParserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("parse/")
public class ParserController {
    ParserService parserService;

    public ParserController(ParserService parserService){
        this.parserService = parserService;
    }
    @GetMapping("{number}")
    public String parse(@PathVariable String number){
        return this.parserService.parse(Integer.parseInt(number));
    }
}
