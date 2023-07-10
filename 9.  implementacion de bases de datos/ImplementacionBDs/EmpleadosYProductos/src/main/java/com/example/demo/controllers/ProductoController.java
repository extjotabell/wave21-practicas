package com.example.demo.controllers;

import com.example.demo.domain.Empleado;
import com.example.demo.domain.Producto;
import com.example.demo.services.EmpleadoService;
import com.example.demo.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto) {
        return productoService.saveProducto(producto);
    }

    @PutMapping("/{id}")
    public Producto modificarProducto(@PathVariable String id, @RequestBody Producto producto) {
        producto.setId(id);
        return productoService.updateProducto(producto);
    }
}
