package com.empleadosproductospg.controller;

import com.empleadosproductospg.model.dto.EmpleadoDTO;
import com.empleadosproductospg.service.IEmpleadoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleados")
public class EmpleadoController {

    private IEmpleadoService service;

    public EmpleadoController(IEmpleadoService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<?> getAllEmpleados(){
        return new ResponseEntity<>(service.getAllEmpleados(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> createEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
        return new ResponseEntity<>(service.createEmpleado(empleadoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateEmpleado(@RequestBody EmpleadoDTO empleadoDTO){
        return new ResponseEntity<>(service.updateEmpleado(empleadoDTO), HttpStatus.OK);
    }
}