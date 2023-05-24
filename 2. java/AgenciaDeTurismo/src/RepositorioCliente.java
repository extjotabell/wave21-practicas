import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RepositorioCliente {
    private List<Cliente> clienteList;

    public RepositorioCliente() {
        this.clienteList = new ArrayList<>();
    }

    public void add(Cliente cli){
        if(search(cli.getNombre()) == null)
            clienteList.add(cli);
    }

    public Cliente search(String nombre){
        for (Cliente cli: clienteList){
            if(cli.getNombre()==nombre)
                return cli;
        }
        return null;
    }
}
