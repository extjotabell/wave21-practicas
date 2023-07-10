package com.example.demo.service;

import com.example.demo.domain.Producto;
import com.example.demo.elasticrepositories.IProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  IProductoRepository productoRepository;

  public List<Producto> getAllProducts() {
    return productoRepository.findAll();
  }
  public String create(Producto p) {
    return productoRepository.save(p).getId();
  }
  public String update(String id, Producto up) {
    Producto p = productoRepository.findById(id).orElseThrow();

    p.setName(up.getName());
    p.setPrecio(up.getPrecio());
    p.setTipo(up.getTipo());

    return productoRepository.save(p).getId();
  }

}
