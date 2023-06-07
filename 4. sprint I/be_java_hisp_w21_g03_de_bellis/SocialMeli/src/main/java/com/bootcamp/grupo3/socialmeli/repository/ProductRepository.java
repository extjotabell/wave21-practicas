package com.bootcamp.grupo3.socialmeli.repository;

import com.bootcamp.grupo3.socialmeli.model.Product;
import com.bootcamp.grupo3.socialmeli.repository.interfaces.IProductRepository;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements IProductRepository {
  private final List<Product> products = new ArrayList<>();
  private int id = 0;

  public int save(final Product p) {
    products.add(p);
    p.setId(products.size());

    return p.getId();
  }

  public Optional<Product> getById(final int id) {
    return products
      .stream()
      .filter(p -> p.getId() == id)
      .findFirst();
  }

  public boolean productExist(final Product p) {
    return products.contains(p);
  }

  @Override
  public Optional<Integer> getByProductId(int productId) {
    return products
      .stream()
      .filter(p -> p.getProductId() == productId)
      .map(Product::getId)
      .findFirst();
  }
}
