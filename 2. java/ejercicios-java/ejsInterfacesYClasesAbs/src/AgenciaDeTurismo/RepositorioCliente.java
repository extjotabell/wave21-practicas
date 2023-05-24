package AgenciaDeTurismo;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente implements Repositorio<Cliente> {
    List<Cliente> listaClientes;

    @Override
    public void agregarAlRepositorio(Cliente obj) {
        listaClientes.add(obj);
        System.out.println(obj.toString());
    }

    @Override
    public void search(Cliente obj) {
        boolean flag = false;
        for (Cliente c : listaClientes){
            if(c.getDni() == obj.getDni()){
                System.out.println(c.toString());
                flag = true;
                break;
            }
            if(!flag)
                System.out.println("No se encontro el cliente en el repositorio!");
        }
    }

    public RepositorioCliente() {
        this.listaClientes = new ArrayList<Cliente>();
    }
}
