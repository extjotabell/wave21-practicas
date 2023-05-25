package repository;

import clases.Client;
import interfaces.CRUD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class ClientRepository implements CRUD<Client> {
    private ClientRepository(){ }
    private static ClientRepository instance = new ClientRepository();
    public static ClientRepository getInstance() { return instance; }

    private Collection<Client> clients = new ArrayList<>();
    @Override
    public void create(Client object) {
        clients.add(object);
    }

    @Override
    public Client read(String id) {
        return clients
                .stream()
                .filter(client -> client.getDni().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void update(Client object, String id) {
        Client toRemove = this.read(object.getDni());

        clients.remove(toRemove);
        clients.add(object);
    }

    @Override
    public void delete(Client object) {
        clients.remove(object);
    }

    @Override
    public Collection<Client> getAll() {
        return clients;
    }


}
