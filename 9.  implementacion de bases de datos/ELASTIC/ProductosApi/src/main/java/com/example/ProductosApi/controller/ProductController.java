package com.example.ProductosApi.controller;

import com.example.ProductosApi.dto.ProductDto;
import com.example.ProductosApi.service.ProductService;
import com.example.ProductosApi.service.ProductServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
@RestController
@RequestMapping("/product")
public class ProductController {
    ProductService productService;
    ProductController(ProductServiceImpl productService){
        this.productService = productService;
    }
    @PostMapping("/save")
    public ResponseEntity<ProductDto> save(@RequestBody ProductDto product){
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.OK);
    }
}
