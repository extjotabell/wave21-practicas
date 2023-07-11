package com.obrasliterarias.repository;

import com.obrasliterarias.model.entity.Obra;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IObraRepository extends ElasticsearchRepository<Obra,String> {
    List<Obra> findByAutor(String autor);

    List<Obra> findByNombreContaining(String title);

    List<Obra> findByCantidadPaginasGreaterThan(Integer cantidad);

    List<Obra> findByYearGreaterThanEqual(Integer year);

    List<Obra> findByYearLessThanEqual(Integer year);

    List<Obra> findByEditorialEquals(String editorial);
}
