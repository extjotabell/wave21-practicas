package org.example.Supermercado.repository;

import org.example.Supermercado.model.Cliente;
import org.example.Supermercado.model.Factura;
import org.example.Supermercado.model.Item;


import java.util.ArrayList;
import java.util.List;

public class RepoFactura {
    private List<Factura> facturas = new ArrayList<>();

    public RepoFactura(List<Factura> facturas) {
        this.facturas = facturas;
    }

    public RepoFactura() {
    }

    public void generarFactura(RepoCliente repoCliente, Cliente cliente, List<Item> items){
        if (repoCliente.buscarPorDNI(cliente.getDni())){
            Factura factura = new Factura(cliente, items, calcularCostoTotal(items));
            facturas.add(factura);
        } else{
            repoCliente.guardar(cliente);
            Factura factura = new Factura(cliente, items, calcularCostoTotal(items));
            facturas.add(factura);
        }
    }

    public double calcularCostoTotal(List<Item> items){
        double costo = 0;
        for (Item item : items) {
        costo+= item.getPrecioUnitario()*item.getCantComprada();
        }
        return costo;
    }

    public void imprimir(){
        for (int i= 0; i <this.facturas.size(); i++){
            System.out.println(this.facturas.get(i));
        }
    }
}
