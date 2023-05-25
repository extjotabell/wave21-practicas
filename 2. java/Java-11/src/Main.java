import clases.Bill;
import clases.Client;
import clases.Product;
import repository.ClientRepository;
import service.BillService;
import service.ClientService;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ClientService.getInstance().create(new Client("50648614", "Matias", "Tato"));
        ClientService.getInstance().create(new Client("12345678", "Pepe", "Perez"));
        ClientService.getInstance().create(new Client("87654321", "Maria", "Gonzalez"));

        ClientService.getInstance().printAllClients();
        ClientService.getInstance().searchClient();

        Collection<Product> products = new ArrayList<>();
        products.add(new Product("1", "Agua", 3, 50));
        products.add(new Product("2", "Leche", 1, 60));
        products.add(new Product("3", "Pan", 2, 30));

        BillService.getInstance().create(ClientService.getInstance().getClient("50648614"), products);
        BillService.getInstance().printAllBills();
    }
}