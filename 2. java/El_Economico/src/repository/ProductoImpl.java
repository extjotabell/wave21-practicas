package repository;

import models.Producto;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ProductoImpl implements CRUD<Producto>{
    List<Producto> listProduct = new ArrayList<>();

    @Override
    public void save(Producto obj) {
        listProduct.add(obj);
    }

    @Override
    public void delete(Integer id) {
        this.listProduct = this.listProduct.stream()
                .filter(p -> p.getId() != id)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Producto> update(Producto obj) {
        return Optional.empty();
    }

    @Override
    public void read() {

    }

    @Override
    public Optional<Producto> search(Integer id) {
        return Optional.empty();
    }

    public List<Producto> getAll() {
        return this.listProduct;
    }
}
