package EjercicioIntegrador.repository;

import EjercicioIntegrador.model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class RepoCliente implements ICrud<Cliente>{
    List<Cliente> listaClientes = new ArrayList<>();
    @Override
    public void eliminar(String id) {
        Optional<Cliente> cliente = buscar(id);
        if(!cliente.isEmpty()){
            listaClientes.remove(cliente);
        }
    }

    @Override
    public void agregar(Cliente cliente) {
        listaClientes.add(cliente);
    }

    @Override
    public void modificar(Cliente elemento) {}

    @Override
    public Optional<Cliente> buscar(String id) {
        Optional<Cliente> cliente = null;
        for (Cliente cli: listaClientes) {
            if(cli.getDni().equals(id)){
               cliente =Optional.of(cli);
               return cliente;
            }
        }
        return Optional.empty();
    }
    @Override
    public List<Cliente> traerTodos() {
        return listaClientes;
    }
    public String mostrarCliente(String dniCliente){
        String mensaje = "";
        for(int i = 0; i < listaClientes.size();i++){

            if(listaClientes.get(i).getDni().equals(dniCliente)){
                mensaje += "Nombre: " + listaClientes.get(i).getNombre() +
                                    ". Dni: " + listaClientes.get(i).getDni() +
                                    ". Apellido: " + listaClientes.get(i).getApellido();

            }
        }
        return mensaje;
    }
}
