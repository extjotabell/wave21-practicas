package service;

import clases.Bill;
import clases.Client;
import clases.Product;
import repository.BillRepository;

import java.util.Collection;

public class BillService {
    private BillService(){ }
    private static BillService instance = new BillService();
    public static BillService getInstance() { return instance; }

    public void create(Client client, Collection<Product> products){
        if(!ClientService.getInstance().clientExist(client)) ClientService.getInstance().create(client);

        BillRepository.getInstance().create(new Bill(client, products, calculateTotalPrice(products)));
    }

    private double calculateTotalPrice(Collection<Product> products){
        double total = 0d;
        if(products == null) return total;

        for (Product product: products) {
            total += product.getPrice() * product.getPurchasedAmount();
        }

        return total;
    }

    public void printAllBills(){
        BillRepository.getInstance().getAll().forEach(System.out::println);
    }
}
