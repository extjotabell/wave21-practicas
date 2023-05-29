package org.parteI.logic;

import org.parteI.model.Cliente;
import org.parteI.model.Factura;
import org.parteI.model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class facturaCliente implements iFacturaCliente {

    List<Factura> facturaList = new ArrayList<>();

    @Override
    public void crearFactura(long codigo, Cliente cliente, List<Item> listaProducto) {

        facturaList.add(new Factura(codigo, cliente, listaProducto, calcularTotal(listaProducto)));

    }

    private double calcularTotal(List<Item> listaProducto) {

        return listaProducto.stream().mapToDouble(item -> item.getCantidadCompra() * item.getPrecioUnitario()).sum();
    }

    @Override
    public void consultarFacturas() {
        facturaList.forEach(item -> {
            System.out.println(item.toString());
        });
    }

    @Override
    public void consultarFacturas(long codigo) {

        List<Factura> listaFacturaCod = facturaList.stream().filter(item -> item.getCodigo() == codigo).toList();
        if (listaFacturaCod.size() > 0) {
            listaFacturaCod.forEach(item -> {
                System.out.println(item.toString());
            });
        } else {
            System.out.println("La factura no existe!!");
        }
    }

    @Override
    public void eliminarFactura(long codigo) {
        Optional<Factura> facturaEli = facturaList.stream().filter(item -> item.getCodigo() == codigo).findFirst();

        if (facturaEli.isPresent()) {
            facturaList.remove(facturaEli.get());
            System.out.println("La factura con el codigo: " + codigo + " se elimino correctamnete!!");
            System.out.println("Lista de facturas actualizada");
            consultarFacturas();
        } else {
            System.out.println("El cliente con Dni: " + codigo + " no existe!!");
        }

    }

    @Override
    public void actualizarFactura(long codigo, Cliente cliente, List<Item> listaProducto, double totalCompra) {

    }


}
