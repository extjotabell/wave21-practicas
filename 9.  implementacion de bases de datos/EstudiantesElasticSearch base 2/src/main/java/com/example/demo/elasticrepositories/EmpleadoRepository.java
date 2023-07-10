package com.example.demo.elasticrepositories;

import com.example.demo.domain.Empleado;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.client.erhlc.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.elasticsearch.client.elc.QueryBuilders.matchQuery;

@Repository
public interface EmpleadoRepository extends ElasticsearchRepository<Empleado, String> {

    List<Empleado> findAll();

    @Query("{\"bool\": {\"filter\": [{\"term\": {\"edad\": \"?0\"}}]}}")
    List<Empleado> findByEdad(String edad);

    List<Empleado> findEmpleadoByNombreStartingWith(String nombre, Sort orden);

    @Query("{\"bool\": {\"must\": [{\"term\": {\"nombre\": {\"value\": \"?0\"}}},{\"term\": {\"ciudad\": {\"value\": \"?1\"}}}]}}}")
    List<Empleado> metodo1(String nombre, String ciudad);
    
}


