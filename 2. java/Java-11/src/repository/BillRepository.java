package repository;

import clases.Bill;
import interfaces.CRUD;

import java.util.ArrayList;
import java.util.Collection;

public class BillRepository implements CRUD<Bill> {
    private BillRepository(){ }
    private static BillRepository instance = new BillRepository();
    public static BillRepository getInstance() { return instance; }

    private Collection<Bill> bills = new ArrayList<>();
    @Override
    public void create(Bill object) {
        bills.add(object);
    }

    @Override
    public Bill read(String id) { return null; }

    @Override
    public void update(Bill object, String id) { }

    @Override
    public void delete(Bill object) {
        bills.remove(object);
    }

    @Override
    public Collection<Bill> getAll() {
        return bills;
    }
}
