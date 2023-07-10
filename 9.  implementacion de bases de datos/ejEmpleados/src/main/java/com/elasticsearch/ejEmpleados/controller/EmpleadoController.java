package com.elasticsearch.ejEmpleados.controller;

import com.elasticsearch.ejEmpleados.model.Empleado;
import com.elasticsearch.ejEmpleados.service.EmpleadoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {

    private EmpleadoService empleadoService;

    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService=empleadoService;
    }

    @PostMapping("/save")
    public ResponseEntity<Empleado> save(@RequestBody Empleado empleado){
        return ResponseEntity.ok(empleadoService.save(empleado));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Empleado> update(@PathVariable String id,
                                           @RequestBody Empleado empleado){
        return ResponseEntity.ok(empleadoService.update(id,empleado));
    }
}
