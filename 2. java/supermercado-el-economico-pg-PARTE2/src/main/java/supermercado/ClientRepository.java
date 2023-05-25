package supermercado;

import supermercado.interfaces.GenericInterface;

import java.util.List;
import java.util.Map;

public class ClientRepository implements GenericInterface<Cliente, Map<String,Cliente>> {

    private Map<String,Cliente> clientes;

    public ClientRepository(Map<String, Cliente> clientes) {
        this.clientes = clientes;
    }

    public Map<String, Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(Map<String, Cliente> clientes) {
        this.clientes = clientes;
    }


    @Override
    public void imprimir() {
        clientes.forEach((dni,cliente) -> {
            System.out.println("----------------------------------------\n" +
                    "Nombre: " + cliente.getNombre() + "\n" +
                    "Apellido: " + cliente.getApellido() + "\n" +
                    "DNI: " + dni);
        });
    }

    @Override
    public void add(Cliente cliente, Map<String, Cliente> clientes) {
        clientes.put(cliente.getDni(), cliente);
    }

    @Override
    public void delete(Cliente cliente, Map<String, Cliente> clientes) {
        if(clientes.containsKey(cliente.getDni())){
            clientes.remove(cliente.getDni());
            System.out.println("\n\nEl cliente con DNI: " + cliente.getDni() + ". Se ha eliminado");
        }else{
            System.out.println("\n\nEl cliente que intenta eliminar no existe");
        }
    }

    @Override
    public void update(Cliente cliente) {
        this.clientes.put(cliente.getDni(), cliente);
    }

    @Override
    public boolean isExist(Cliente cliente) {
        return clientes.containsKey(cliente.getDni());
    }
}