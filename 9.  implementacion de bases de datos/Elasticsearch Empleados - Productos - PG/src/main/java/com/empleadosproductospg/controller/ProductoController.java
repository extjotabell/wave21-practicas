package com.empleadosproductospg.controller;

import com.empleadosproductospg.model.dto.ProductoDTO;
import com.empleadosproductospg.service.IProductoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {
    private IProductoService service;

    public ProductoController(IProductoService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<?> getAllProductos(){
        return new ResponseEntity<>(service.getAllProductos(), HttpStatus.OK);
    }

    @PostMapping("/save")
    public ResponseEntity<?> createProducto(@RequestBody ProductoDTO productoDTO){
        return new ResponseEntity<>(service.createProducto(productoDTO), HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateProducto(@RequestBody ProductoDTO productoDTO){
        return new ResponseEntity<>(service.updateProducto(productoDTO), HttpStatus.OK);
    }
}