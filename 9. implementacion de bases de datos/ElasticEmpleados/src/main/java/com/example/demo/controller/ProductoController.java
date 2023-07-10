package com.example.demo.controller;

import com.example.demo.domain.Producto;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductoController {
  @Autowired
  private ProductService productService;

  @GetMapping("/products")
  public ResponseEntity<List<Producto>> getAllProducts() {
    return ResponseEntity.ok(productService.getAllProducts());
  }
  @PostMapping("/product")
  public ResponseEntity<?> create(@RequestBody Producto p) {
    return ResponseEntity.ok(productService.create(p));
  }

  @PutMapping("/product/{id}")
  public ResponseEntity<?> update(
    @PathVariable final String id,
    @RequestBody final Producto p
  ) {
    return ResponseEntity.ok(productService.update(id, p));
  }
}
