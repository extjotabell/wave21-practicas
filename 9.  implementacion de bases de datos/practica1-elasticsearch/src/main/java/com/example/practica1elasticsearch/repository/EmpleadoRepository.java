package com.example.practica1elasticsearch.repository;

import com.example.practica1elasticsearch.model.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {
    List<Empleado> findAll();

    List<Empleado> findAllByEdad(int edad);

    List<Empleado> findAllByNombreAndCiudadContains(String nombre, String ciudad);
}
