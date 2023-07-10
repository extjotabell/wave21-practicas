package com.elasticsearch.ejEmpleados.service;

import com.elasticsearch.ejEmpleados.model.Empleado;

public interface EmpleadoService {

    Empleado save(Empleado empleado);

    Empleado update(String id,Empleado empleado);
}
