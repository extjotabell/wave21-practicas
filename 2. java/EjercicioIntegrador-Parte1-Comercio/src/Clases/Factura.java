package Clases;

import java.util.List;

public class Factura {
    //region Variables Privadas
    private Long codigo;
    private Cliente cliente;
    private List<Item> items;
    private double total;
    //endregion


    //region Getters / Setters
    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    //endregion


    //region Constructores
    public Factura() {}
    public Factura(Long codigo, Cliente cliente) {
        this.codigo = codigo;
        this.cliente = cliente;
    }
    public Factura(Long codigo, Cliente cliente, List<Item> items, double total) {
        this.codigo = codigo;
        this.cliente = cliente;
        this.items = items;
        this.total = total;
    }
    //endregion
}
