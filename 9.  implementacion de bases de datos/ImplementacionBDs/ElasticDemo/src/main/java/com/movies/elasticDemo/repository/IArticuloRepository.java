package com.movies.elasticDemo.repository;

import com.movies.elasticDemo.model.Articulo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface IArticuloRepository extends ElasticsearchRepository<Articulo, String> {

}
