import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Repositorio {

    private Map<Cliente, List<Localizador>> repositorioClientes;

    private Double descuento;

    public Repositorio(){
        repositorioClientes= new HashMap<Cliente, List<Localizador>>();
        descuento=0d;
    }


    public void agregarLocalizador(Localizador localizador){
        Cliente cliente = localizador.getCliente();
        List<Localizador> listaLocalizadores = new ArrayList<Localizador>();
        if(repositorioClientes.containsKey(cliente)){
            listaLocalizadores = repositorioClientes.get(cliente);
        }
        listaLocalizadores.add(localizador);
        repositorioClientes.put(cliente,listaLocalizadores);

    }
    public void mostrarLocalizadoresPorCliente(Cliente cliente) {
        System.out.println("\nLISTA DE LOCALIZADORES DEL CLIENTE "+cliente.getId());
        this.repositorioClientes.forEach((clienteLista, listaLocalizadores) -> {
                    if (clienteLista == cliente) {
                        listaLocalizadores.forEach(Localizador::imprimirLocalizador);
                    }
                }
        );
    }

    public void mostrarProximoDescuentoPorCliente(Cliente cliente){
        Double descuento=0d;
        Double suma=0d,cantidad=0d;
        System.out.println("\nLISTA DE LOCALIZADORES DEL CLIENTE "+cliente.getId());
        /*for (Map.Entry<Cliente,List<Localizador>> entry:repositorioClientes.entrySet()) {
            if(entry.getKey()==cliente){
                suma+=entry.getValue().stream().mapToDouble(l->l.getTotal()).sum();
                cantidad++;
            }
        }*/

    }

    public Map<Cliente, List<Localizador>> getRepositorioClientes() {
        return repositorioClientes;
    }

    public void setRepositorioClientes(Map<Cliente, List<Localizador>> repositorioClientes) {
        this.repositorioClientes = repositorioClientes;
    }
}
