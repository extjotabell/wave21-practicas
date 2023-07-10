package com.elasticsearch.ejEmpleados.service.impls;

import com.elasticsearch.ejEmpleados.model.Empleado;
import com.elasticsearch.ejEmpleados.repositories.EmpleadoRepository;
import com.elasticsearch.ejEmpleados.service.EmpleadoService;
import org.springframework.stereotype.Service;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

    EmpleadoRepository empleadoRepository;

    public EmpleadoServiceImpl(EmpleadoRepository empleadoRepository){
        this.empleadoRepository=empleadoRepository;
    }

    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    public Empleado update(String id,Empleado empleado){
        Empleado empleadoResponse = empleadoRepository.findById(id).orElse(null);

        if(empleadoResponse==null)
            return null;

        empleado.setId(empleadoResponse.getId());

        return empleadoRepository.save(empleado);
    }
}
