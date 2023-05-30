package com.example.romanos.controller;

import com.example.romanos.service.OutOfNumberException;
import com.example.romanos.service.RomanoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class Romanos {

  @GetMapping("/romano/{number}")
  public String convert(@PathVariable String number) {
    List<String> caracteres = new ArrayList<>();

    for(int i=0;i<number.length();++i)
      caracteres.add(String.valueOf(number.charAt(i))); // ["100", "20", "0"]

    try {
      List<String> romano = RomanoService.decimalARomano(caracteres);

      Collections.reverse(romano);

      return String.join("", romano);
    } catch(OutOfNumberException e) {
      e.printStackTrace();
      return e.getMessage();
    }
  }
}
