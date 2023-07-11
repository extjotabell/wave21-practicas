package com.empleadosproductospg.repository;

import com.empleadosproductospg.model.entity.Empleado;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends ElasticsearchRepository<Empleado,String> {
}
