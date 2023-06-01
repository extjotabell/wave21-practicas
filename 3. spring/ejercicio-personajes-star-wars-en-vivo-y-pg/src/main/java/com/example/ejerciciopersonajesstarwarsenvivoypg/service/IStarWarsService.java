package com.example.ejerciciopersonajesstarwarsenvivoypg.service;

import org.springframework.http.ResponseEntity;

public interface IStarWarsService {
    public ResponseEntity<?> artistsByName(String name);
}
