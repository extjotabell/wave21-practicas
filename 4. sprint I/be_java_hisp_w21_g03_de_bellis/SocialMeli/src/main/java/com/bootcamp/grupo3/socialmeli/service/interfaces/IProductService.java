package com.bootcamp.grupo3.socialmeli.service.interfaces;

import com.bootcamp.grupo3.socialmeli.dto.request.ProductDTO;
import com.bootcamp.grupo3.socialmeli.model.Product;

public interface IProductService {
  int createProduct(ProductDTO product);
  ProductDTO getProductDtoById(int productId);
}
