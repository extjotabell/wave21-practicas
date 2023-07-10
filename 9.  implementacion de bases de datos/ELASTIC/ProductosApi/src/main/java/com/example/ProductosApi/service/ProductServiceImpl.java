package com.example.ProductosApi.service;

import com.example.ProductosApi.domain.Product;
import com.example.ProductosApi.dto.ProductDto;
import com.example.ProductosApi.elasticrepositories.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService{
    ProductRepository productRepository;
    ModelMapper mapper;
    ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
        mapper =  new ModelMapper();
    }
    @Override
    public ProductDto saveProduct(ProductDto product) {
        Product saved = productRepository.save(mapper.map(product, Product.class));
        return mapper.map(saved, ProductDto.class);
    }
}
