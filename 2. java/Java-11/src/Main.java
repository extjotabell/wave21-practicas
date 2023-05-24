import clases.Client;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Client> clients = new ArrayList<>();
        clients.add(new Client("50648614", "Matias", "Tato"));
        clients.add(new Client("12345678", "Pepe", "Perez"));
        clients.add(new Client("87654321", "Maria", "Gonzalez"));

        clients.forEach(System.out::println);

        clients.remove(2);
        clients.forEach(System.out::println);


        Scanner scanner = new Scanner(System.in);
        String dni = scanner.next();

        Optional<Client> optional = clients.stream().filter(client -> client.getDni().equals(dni)).findFirst();

        if(optional.isPresent()) System.out.println(optional.get().toString());
        else System.out.println("Usuario no encontrado");
    }
}