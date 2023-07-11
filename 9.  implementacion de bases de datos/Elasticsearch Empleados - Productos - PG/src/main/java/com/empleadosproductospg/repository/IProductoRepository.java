package com.empleadosproductospg.repository;

import com.empleadosproductospg.model.entity.Producto;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends ElasticsearchRepository<Producto, String> {
}
