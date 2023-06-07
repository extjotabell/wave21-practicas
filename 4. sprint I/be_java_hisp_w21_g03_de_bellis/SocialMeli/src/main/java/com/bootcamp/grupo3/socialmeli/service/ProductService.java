package com.bootcamp.grupo3.socialmeli.service;

import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.bootcamp.grupo3.socialmeli.model.Product;
import com.bootcamp.grupo3.socialmeli.repository.ProductRepository;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IProductRepository;
import com.bootcamp.grupo3.socialmeli.service.interfaces.IProductService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements IProductService {
  private IProductRepository productRepository;
  private ModelMapper modelMapper;

  public ProductService(IProductRepository productRepository, ModelMapper modelMapper) {
    this.productRepository = productRepository;
    this.modelMapper = modelMapper;
  }

  @Override
  public int createProduct(ProductDTO p) {
    Product product = modelMapper.map(p, Product.class);

    return productRepository.getByProductId(p.getProductId())
      .orElseGet(() -> productRepository.save(product));
  }
  public ProductDTO getProductDtoById(int productId) {
    Product p = productRepository.getById(productId).orElseThrow();

    return new ProductDTO(
      p.getId(),
      p.getProductId(),
      p.getProductName(),
      p.getType(),
      p.getBrand(),
      p.getColor(),
      p.getNotes()
    );
  }
}
