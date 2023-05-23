package supermercado;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Factura {
    private Cliente cliente;
    private List<Item> items;
    private double montoTotal;

    public Factura(Cliente cliente, List<Item> items, double montoTotal) {
        this.cliente = cliente;
        this.items = items;
        this.montoTotal = montoTotal;
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

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void calcularTotal(){
        AtomicReference<Double> counter = new AtomicReference<>(0D);
        items.forEach(item -> {
            counter.updateAndGet(v -> new Double((double) (v + (item.getCostoUnitario() * item.getCantidadComprada()))));
        });
        this.montoTotal = counter.get();
    }
}
