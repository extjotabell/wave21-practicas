package com.example.practica1elasticsearch.controller;

import com.example.practica1elasticsearch.model.Empleado;
import com.example.practica1elasticsearch.repository.EmpleadoRepository;
import com.example.practica1elasticsearch.service.IEmpleadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmpleadoController {
    private final IEmpleadoService empleadoController;

    public EmpleadoController(IEmpleadoService empleadoController) {
        this.empleadoController = empleadoController;
    }

    @PostMapping("/empleado")
    public Empleado saveEmpleado(@RequestBody Empleado empleado){
        return empleadoController.save(empleado);
    }

    @GetMapping("/empleado/all")
    public Iterable<Empleado> getAllEmpleados(){
        return empleadoController.findAll();
    }
}
