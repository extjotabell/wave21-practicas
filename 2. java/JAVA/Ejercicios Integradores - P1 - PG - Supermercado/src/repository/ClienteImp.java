package repository;

import model.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClienteImp implements CRUDRepository<Cliente> {

    List<Cliente> clientes = new ArrayList<Cliente>();

    @Override
    public void save(Cliente obj) {
        clientes.add(obj);

    }

    @Override
    public void mostrarPantalla() {
        if(clientes.isEmpty()){
            System.out.println("No hay Clientes en el sistema!");
        }
        for (Cliente c : clientes) {
            System.out.println(c.toString());
        }
    }

    @Override
    public Optional<Cliente> buscar(Long dniBuscado) {
        boolean flag = false;
        for (Cliente c : clientes) {
            if (c.getDni().equals(dniBuscado)) {
                System.out.println(c.toString());
                flag = true;
                return Optional.of(c);
            }
        }

        if (flag == false) {
            System.out.println("No se encontro el model.Cliente!");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long dniBorrado) {
        Optional<Cliente> cli = this.buscar(dniBorrado);

        if (cli.isEmpty()) {
            System.out.println("No existe el cliente!");
        } else{
            clientes.remove(cli.get());
            System.out.println("Cliente eliminado con éxito!");
        }
    }

    @Override
    public List<Cliente> traerTodos() {
        return clientes;
    }
}
