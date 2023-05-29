package repository;

import models.Factura;

import java.util.List;
import java.util.Optional;

public class FacturaImpl implements CRUD<Factura>{
    private List<Factura> listFacturas;
    @Override
    public void save(Factura obj) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public Optional<Factura> update(Factura obj) {
        return Optional.empty();
    }

    @Override
    public void read() {

    }

    @Override
    public Optional<Factura> search(Integer id) {
        return Optional.empty();
    }

    public List<Factura> getAll() {
        return this.listFacturas;
    }
}
