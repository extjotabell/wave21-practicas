package EjercicioIntegrador.repository;

import EjercicioIntegrador.model.Cliente;
import EjercicioIntegrador.model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepoFactura implements ICrud<Factura> {

    List<Factura> listaFacturas = new ArrayList<>();
    @Override
    public void eliminar(String id) {

    }

    @Override
    public void agregar(Factura elemento) {
        if(!elemento.equals(null)){
            listaFacturas.add(elemento);
        }
    }

    @Override
    public void modificar(Factura elemento) {

    }

    @Override
    public Optional<Factura> buscar(String id) {
        return Optional.empty();
    }

    @Override
    public List<Factura> traerTodos() {
        return null;
    }

}
