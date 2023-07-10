package com.example.demo.services;

import com.example.demo.domain.Empleado;
import com.example.demo.domain.Producto;
import com.example.demo.elasticrepositories.EmpleadoRepository;
import com.example.demo.elasticrepositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoServiceImp implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public Producto saveProducto(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        return productoRepository.save(producto);
    }

}
