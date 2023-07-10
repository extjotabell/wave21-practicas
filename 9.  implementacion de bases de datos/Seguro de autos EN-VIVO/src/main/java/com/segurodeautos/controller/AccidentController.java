package com.segurodeautos.controller;

import com.segurodeautos.dto.request.AccidentDTO;
import com.segurodeautos.service.AccidentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/accident")
public class AccidentController {

    private AccidentService service;

    public AccidentController(AccidentService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<?> createAccident(@RequestBody AccidentDTO accidentDTO){
        return new ResponseEntity<>(service.createAccident(accidentDTO), HttpStatus.CREATED);
    }
}
