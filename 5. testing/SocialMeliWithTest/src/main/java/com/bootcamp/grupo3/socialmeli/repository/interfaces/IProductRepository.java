package com.bootcamp.grupo3.socialmeli.repository.interfaces;

import com.bootcamp.grupo3.socialmeli.model.Product;

import java.util.Optional;

public interface IProductRepository {
  int save(Product p);
  boolean productExist(Product p);
  Optional<Integer> getByProductId(int productId);
  Optional<Product> getById(int id);
}
