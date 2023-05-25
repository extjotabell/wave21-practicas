package supermercado;

import supermercado.wrappers.ClientItemsWrapper;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        ClientRepository clientRepository = new ClientRepository(new HashMap<>());

        Cliente cliente1 = new Cliente("2525","Jose", "Gonzalez");

        clientRepository.add(cliente1 ,clientRepository.getClientes());
        clientRepository.add(new Cliente("2626","Pepito", "Perez"),clientRepository.getClientes());
        clientRepository.add(new Cliente("2727","Sebastian", "Nadal"),clientRepository.getClientes());

        clientRepository.delete(cliente1, clientRepository.getClientes());
        clientRepository.imprimir();

        //PARTE 2

        //Nuevo cliente
        Cliente nuevoCliente = new Cliente("2828","Jack", "Black");

        Item item1 = new Item("123", "Pollo", 2, 10.0);
        Item item2 = new Item("234", "Carne", 1, 20.0);
        Item item3 = new Item("345", "Pescado", 3, 15.0);
        Item item4 = new Item("456", "Harina", 1, 5.0);
        List<Item> items = new ArrayList<>(Arrays.asList(item1, item2, item3, item4));

        Factura factura = new Factura();
        factura.add(new ClientItemsWrapper(nuevoCliente, items), clientRepository);
        factura.imprimir();
    }
}
