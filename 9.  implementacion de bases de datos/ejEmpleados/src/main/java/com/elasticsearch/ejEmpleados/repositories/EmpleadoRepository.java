package com.elasticsearch.ejEmpleados.repositories;

import com.elasticsearch.ejEmpleados.model.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado,String> {
}
