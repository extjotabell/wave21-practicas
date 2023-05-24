import java.util.ArrayList;
import java.util.List;

public class Factura {
    private int numero;
    private Cliente cliente;
    private List<Item> items;

    public Factura(int numero, Cliente cliente) {
        this.numero = numero;
        this.cliente = cliente;
        this.items = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<Item> getItems() {
        return items;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public void removeItem(Item item) {
        items.remove(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (Item item : items) {
            total += item.getPrecio();
        }
        return total;
    }

    public String toString() {
        return "Factura #" + numero + " - Cliente: " + cliente.getNombre() + " - Total: $" + calcularTotal();
    }
}
