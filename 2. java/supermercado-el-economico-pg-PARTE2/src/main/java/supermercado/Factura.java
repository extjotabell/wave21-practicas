package supermercado;

import supermercado.interfaces.GenericInterface;
import supermercado.wrappers.ClientItemsWrapper;

import java.util.List;

public class Factura implements GenericInterface<ClientItemsWrapper, ClientRepository> {
    private Cliente cliente;
    private List<Item> items;
    private double montoTotal;

    public Factura() {
    }

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
        final double[] counter = {0D};
        items.forEach(item -> {
            counter[0] = counter[0] + (item.getCostoUnitario() * item.getCantidadComprada());
        });
        this.montoTotal = counter[0];
    }

    @Override
    public void imprimir() {
        System.out.println("------------------------------------------------\n" +
                "Supermercado “El Económico”\n" +
                "------------------------------------------------\n" +
                "Nombre cliente: " + cliente.getNombre() + " " + cliente.getApellido() + "\n" +
                "DNI: " + cliente.getDni() + "\n" +
                "----------------------------\n" +
                "ITEMS:\n" +
                "----------------------------");
        items.forEach(item -> {
            System.out.println(item.getNombre() + " ................. Cant: " + item.getCantidadComprada() + "  Costo Unidad: $" + item.getCostoUnitario() );
        });
        System.out.println("TOTAL: $" + montoTotal);
    }

    @Override
    public void add(ClientItemsWrapper clientItemsWrapper, ClientRepository clientRepository) {
        Cliente cliente = clientItemsWrapper.getCliente();
        List<Item> items = clientItemsWrapper.getItems();
        if(!clientRepository.isExist(cliente)){
            clientRepository.update(cliente);
            System.out.println("Cliente nuevo con DNI: " + cliente.getDni() + " ha sido creado.");
        }
        this.setCliente(cliente);
        this.setItems(items);
        this.calcularTotal();
    }

    @Override
    public void delete(ClientItemsWrapper clientItemsWrapper, ClientRepository clientRepository) {

    }

    @Override
    public void update(ClientItemsWrapper clientItemsWrapper) {

    }

    @Override
    public boolean isExist(ClientItemsWrapper clientItemsWrapper) {
        return false;
    }

}
