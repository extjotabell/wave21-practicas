import java.util.ArrayList;
import java.util.List;


public class RepositorioCliente implements Repository<Cliente> {
    List<Cliente> clientes = new ArrayList<>();
    @Override
    public Cliente findBy(String id) {
        return (Cliente) clientes.stream().filter(cliente -> cliente.dni.equals(id));
    }

    @Override
    public void save(Cliente obj) {
        this.clientes.add(obj);
    }

    @Override
    public List<Cliente> findAll() {
        return this.clientes;
    }
}
