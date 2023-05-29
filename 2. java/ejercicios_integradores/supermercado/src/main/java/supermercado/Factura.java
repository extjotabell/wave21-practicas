package supermercado;

import java.util.ArrayList;
import java.util.HashMap;

public class Factura {
    private Cliente cliente;
    private ArrayList<Item> items;
    private double total = 0D;

    public Factura(Cliente cliente, ArrayList<Item> items) {
        this.cliente = cliente;
        if(!items.isEmpty()){
            this.items = items;
            total = items.stream().mapToDouble(Item::obtenerPrecio).sum();
        }else{
            items = new ArrayList<>();
        }
    }

    public void agregar(Item item){
        items.add(item);
        total += item.obtenerPrecio();
    }

    public boolean esAgregable(HashMap<String, Cliente> clientes) {
        return (clientes.get(cliente.obtenerDni()) != null) && !items.isEmpty() && total > 0;
    }
}
