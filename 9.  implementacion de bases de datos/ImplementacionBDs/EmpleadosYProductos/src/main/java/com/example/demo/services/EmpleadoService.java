package com.example.demo.services;

import com.example.demo.domain.Empleado;

public interface EmpleadoService {


    Empleado saveEmpleado(Empleado empleado);

    Empleado updateEmpleado(Empleado empleado);
}
