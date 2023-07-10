package com.example.demo.elasticrepositories;

import com.example.demo.domain.ObraLiteraria;
import org.springframework.data.domain.Sort;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ObraLiterariaRepository extends ElasticsearchRepository<ObraLiteraria, String> {



    List<ObraLiteraria> findAll();

    @Query("{\"bool\": {\"filter\": [{\"term\": {\"autor\": \"?0\"}}]}}")
    List<ObraLiteraria> findByAutor(String autor);

    List<ObraLiteraria> findObraLiterariaByAutorStartingWith(String nombre, Sort orden);

    @Query("{\"bool\": {\"must\": [{\"term\": {\"nombre\": {\"value\": \"?0\"}}},{\"term\": {\"ciudad\": {\"value\": \"?1\"}}}]}}}")
    List<ObraLiteraria> metodo1(String nombre, String ciudad);
}


