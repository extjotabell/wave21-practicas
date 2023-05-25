package repository;

import model.Cliente;
import model.Factura;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaImp implements CRUDRepository<Factura> {

    List<Factura> facturas = new ArrayList<Factura>();
    @Override
    public void save(Factura fact) {
        Cliente cli = fact.getCliente();
        facturas.add(fact);

    }

    @Override
    public void mostrarPantalla() {
        if(facturas.isEmpty()){
            System.out.println("No hay Facturas en el sistema!");
        }
        for (Factura f : facturas) {
            System.out.println(f.toString());
        }
    }

    @Override
    public Optional<Factura> buscar(Long codigoBuscado) {
        boolean flag = false;
        for (Factura f : facturas) {
            if (f.getCodigo().equals(codigoBuscado)) {
                System.out.println(f.toString());
                flag = true;
                return Optional.of(f);
            }
        }

        if (flag == false) {
            System.out.println("No se encontro la factura");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long codigoBorrado) {
        Optional<Factura> fact = this.buscar(codigoBorrado);

        if (fact.isEmpty()) {
            System.out.println("No existe la factura!");
        } else{
            facturas.remove(fact.get());
            System.out.println("Factura eliminada con éxito!");
        }
    }

    @Override
    public List<Factura> traerTodos() {
        return facturas;
    }
}
