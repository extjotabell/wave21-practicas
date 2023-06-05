package com.example.dto_response_entity_VIVO_p_2.service;

import com.example.dto_response_entity_VIVO_p_2.repository.IDeporteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeporteService implements IDeporteService {
    @Autowired
    IDeporteRepository repository;
    @Override
    public ResponseEntity<?> getSport() {
        return new ResponseEntity<>(repository.getSport(), HttpStatus.OK);
    }
    @Override
    public ResponseEntity<?> getByName(String name) {
        return new ResponseEntity<>(repository.getByName(name), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getSportsByPerson() {
        return new ResponseEntity<>(repository.getSportsByPerson(), HttpStatus.OK);
    }
}
