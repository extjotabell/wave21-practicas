package com.empleadosproductospg.service;

import com.empleadosproductospg.model.dto.ProductoDTO;
import com.empleadosproductospg.model.entity.Producto;
import com.empleadosproductospg.repository.IProductoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoService implements IProductoService {

    private IProductoRepository repository;
    private ModelMapper mapper;

    public ProductoService(IProductoRepository repository, ModelMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ProductoDTO> getAllProductos() {
        List<ProductoDTO> result = new ArrayList<>();
        repository.findAll().forEach(producto -> {
            result.add(mapper.map(producto, ProductoDTO.class));
        });
        return result;
    }

    @Override
    public ProductoDTO createProducto(ProductoDTO productoDTO) {
        return saveProducto(productoDTO);
    }

    @Override
    public ProductoDTO updateProducto(ProductoDTO productoDTO) {
        List<ProductoDTO> filteredList = this.getAllProductos().stream().filter(productoDTO1 -> productoDTO1.getId()
                .equals(productoDTO.getId())).toList();
        if(filteredList.isEmpty()){
            throw new RuntimeException("Producto no encontrado");
        }
        return saveProducto(productoDTO);
    }

    private ProductoDTO saveProducto(ProductoDTO productoDTO){
        Producto response = repository.save(mapper.map(productoDTO, Producto.class));
        return mapper.map(response,ProductoDTO.class);
    }
}