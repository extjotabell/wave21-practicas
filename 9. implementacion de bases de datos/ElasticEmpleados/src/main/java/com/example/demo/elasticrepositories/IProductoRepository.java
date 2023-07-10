package com.example.demo.elasticrepositories;

import com.example.demo.domain.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IProductoRepository extends ElasticsearchRepository<Producto, String> {
  List<Producto> findAll();
}
