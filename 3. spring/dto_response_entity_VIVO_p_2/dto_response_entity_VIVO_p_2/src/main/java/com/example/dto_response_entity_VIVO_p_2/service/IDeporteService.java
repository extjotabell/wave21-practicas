package com.example.dto_response_entity_VIVO_p_2.service;

import org.springframework.http.ResponseEntity;

public interface IDeporteService {
    ResponseEntity<?> getSport();
    ResponseEntity<?> getByName(String name);
    ResponseEntity<?> getSportsByPerson();
}
