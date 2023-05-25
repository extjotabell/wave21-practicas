import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repositorio {

    Map<Cliente, List<Localizador>> repositorioClientes;


    public Repositorio(){
        repositorioClientes= new HashMap<Cliente, List<Localizador>>();
    }


    public void agregarLocalizador(Cliente cliente,Localizador localizador){
        List<Localizador> listaLocalizadores = new ArrayList<Localizador>();
        if(repositorioClientes.containsKey(cliente)){
            listaLocalizadores = repositorioClientes.get(cliente);
        }
        listaLocalizadores.add(localizador);
        repositorioClientes.put(cliente,listaLocalizadores);

    }
    public List<Localizador> listarLocalizadoresPorCliente(Cliente cliente){
        return null;
    }

    public Map<Cliente, List<Localizador>> getRepositorioClientes() {
        return repositorioClientes;
    }

    public void setRepositorioClientes(Map<Cliente, List<Localizador>> repositorioClientes) {
        this.repositorioClientes = repositorioClientes;
    }
}
