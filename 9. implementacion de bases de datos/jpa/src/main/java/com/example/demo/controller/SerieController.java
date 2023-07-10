package com.example.demo.controller;

import com.example.demo.dto.MiniSerieDTO;
import com.example.demo.dto.MiniSerieIdDTO;
import com.example.demo.service.IMiniSerieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class SerieController {
  @Autowired
  IMiniSerieService miniSerieService;

  @PostMapping("/miniSerie")
  ResponseEntity<MiniSerieIdDTO> create(@Valid @RequestBody MiniSerieDTO miniSerieDTO) {
    MiniSerieIdDTO id = miniSerieService.createMiniSerie(miniSerieDTO);
    return new ResponseEntity<MiniSerieIdDTO>(id, HttpStatus.OK);
  }
}
