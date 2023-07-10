package com.example.demo.elasticrepositories;

import com.example.demo.domain.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends ElasticsearchRepository<Producto, String> {
}


