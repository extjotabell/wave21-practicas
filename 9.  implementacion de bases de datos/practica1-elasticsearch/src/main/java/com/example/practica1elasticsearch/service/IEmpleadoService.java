package com.example.practica1elasticsearch.service;

import com.example.practica1elasticsearch.model.Empleado;

import java.util.List;

public interface IEmpleadoService {
    Empleado save(Empleado empleado);

    List<Empleado> getAllByEdad(int edad);

    List<Empleado> findAll();

    List<Empleado> getEmpleadoByNombreAndCiudad(String nombre, String orden);
}
