package repository;

import models.Cliente;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class ClienteImp implements CRUD<Cliente>{
    Map<Integer, Cliente> mapClientes = new HashMap<>();

    @Override
    public void save(Cliente obj) {
        mapClientes.put(obj.getDni(), obj);
    }

    @Override
    public void delete(Integer id) {
        mapClientes.remove(id);
    }

    @Override
    public Optional<Cliente> update(Cliente obj) {
        return Optional.empty();
    }

    @Override
    public void read() {
        System.out.println("-----CLIENTE-----");
        mapClientes.forEach((k, v) -> {
            System.out.println("Nombre: " + v.getNombre());
            System.out.println("\nApellido: " + v.getApellido());
            System.out.println("\nDNI: " + v.getDni());
            System.out.println("--------------------");

        });
    }

    @Override
    public Optional<Cliente> search(Integer id) {
        Cliente per;
        Scanner teclado = new Scanner(System.in);
        Integer dni;
        System.out.println("A CONTINUACION INGRESE EL DNI DEL CLIENTE QUE DESEA VER:\n");
        dni = teclado.nextInt();
        if(mapClientes.containsKey(dni)){
            per = mapClientes.get(dni);
            System.out.println("PERSONA ENCONTRADA:");
            System.out.println("Nombre: " + per.getNombre());
            System.out.println("\nApellido: " + per.getApellido());
            System.out.println("\nDNI: " + per.getDni());
            System.out.println("--------------------");
            return Optional.of(per);
        }
        else {
            System.out.println("PERSONA NO ENCONTRADA!!");
            return Optional.empty();
        }
    }

    public Map<Integer, Cliente> getAll() {
        return this.mapClientes;
    }
}
