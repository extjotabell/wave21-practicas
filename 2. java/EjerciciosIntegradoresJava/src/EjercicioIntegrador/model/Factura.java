package EjercicioIntegrador.model;

import EjercicioIntegrador.repository.ICrud;

import java.util.ArrayList;
import java.util.List;

public class Factura {
    Cliente cliente;
    List<Item> listaItems;
    double totalCompras;

    public Factura(Cliente cliente) {
        this.cliente = cliente;
        this.listaItems = new ArrayList<>();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getListaItems() {
        return listaItems;
    }

    public void setListaItems(List<Item> listaItems) {
        this.listaItems = listaItems;
    }

    public double getTotalCompras() {
        return totalCompras;
    }

    public void setTotalCompras(double totalCompras) {
        this.totalCompras = totalCompras;
    }

    public void agregarItems(Item item) {
        if(item !=null){
            listaItems.add(item);
        }
    }

    public void calcularTotal(){
        double total = 0;
        for(Item it: listaItems) {
            total += (it.getCostoUnitario()* it.cantidadComprada);
        }
        totalCompras = total;
    }
}
