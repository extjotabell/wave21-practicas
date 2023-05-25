package service;

import clases.Client;
import repository.ClientRepository;

import java.util.Scanner;

public class ClientService {
    private ClientService(){ }
    private static ClientService instance = new ClientService();
    public static ClientService getInstance() { return instance; }

    public void create(Client client){
        ClientRepository.getInstance().create(client);
    }

    public Client getClient(String dni){
        return ClientRepository.getInstance().read(dni);
    }

    public void searchClient(){
        Scanner scanner = new Scanner(System.in);
        String dni = scanner.next();

        Client client = ClientRepository.getInstance().read(dni);
        if(client !=null ) System.out.println(client);
        else System.out.println("Usuario no encontrado");
    }

    public void printAllClients(){
        ClientRepository.getInstance().getAll().forEach(System.out::println);
    }

    public boolean clientExist(Client client){
        return ClientRepository.getInstance().read(client.getDni()) != null;
    }
}
