package com.example.demo.services;

import com.example.demo.domain.Empleado;

import java.util.List;

public interface EmpleadoService {

     Empleado save(Empleado empleado);
    List<Empleado> getAllByEdad(String edad);

    List<Empleado> findAll();

    List<Empleado> getEmpleadoByNombreAndCiudad(String nombre, String orden);
}
