package com.example.practica1elasticsearch.service;

import com.example.practica1elasticsearch.model.Empleado;
import com.example.practica1elasticsearch.repository.EmpleadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpleadoService implements IEmpleadoService{
    private final EmpleadoRepository empleadoRepository;

    public EmpleadoService(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }


    @Override
    public Empleado save(Empleado empleado) {
        return empleadoRepository.save(empleado);
    }

    @Override
    public List<Empleado> getAllByEdad(int edad) {
        return empleadoRepository.findAllByEdad(edad);
    }

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }

    @Override
    public List<Empleado> getEmpleadoByNombreAndCiudad(String nombre, String orden) {
        return empleadoRepository.findAllByNombreAndCiudadContains(nombre, orden);
    }
}
