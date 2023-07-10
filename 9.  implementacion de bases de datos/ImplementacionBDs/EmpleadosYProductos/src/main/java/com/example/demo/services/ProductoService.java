package com.example.demo.services;

import com.example.demo.domain.Producto;

public interface ProductoService {
    Producto saveProducto(Producto producto);

    Producto updateProducto(Producto producto);
}
