package com.empleadosproductospg.service;

import com.empleadosproductospg.model.dto.ProductoDTO;
import java.util.List;

public interface IProductoService {
    List<ProductoDTO> getAllProductos();
    ProductoDTO createProducto(ProductoDTO productoDTO);
    ProductoDTO updateProducto(ProductoDTO productoDTO);
}