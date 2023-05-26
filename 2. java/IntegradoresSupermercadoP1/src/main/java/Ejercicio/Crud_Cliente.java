package Ejercicio;

import java.util.ArrayList;
import java.util.List;

public class Crud_Cliente implements CRUD<Cliente>{
    public List<Cliente> clientes = new ArrayList<>();
    @Override
    public boolean agregarElemento(Cliente elemento)
    {
        try
        {
            clientes.add(elemento);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean eliminarElemento (String elemento)
    {
        try
        {
            if(buscarElemento(elemento, clientes) != null){
                Cliente c = buscarElemento(elemento, clientes);
                clientes.remove(c);
            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean actualizarElemento (Cliente elemento)
    {
        try {
            Cliente c = buscarElemento(elemento.getDni(), clientes);
            c.setDni(elemento.getDni());
            c.setNombre(elemento.getNombre());
            c.setApellido(elemento.getApellido());
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }
    @Override
    public Cliente consultarElemento (String elemento)
    {
        return buscarElemento(elemento, clientes);
    }

    public Cliente buscarElemento (String dni, List<Cliente> clientes)
    {
        Cliente c = null;
        boolean encontrado = false;
        for (int i = 0; i < clientes.size(); i++) {
            String dniCliente = clientes.get(i).getDni();
            int esElMismo = dniCliente.compareToIgnoreCase(dni);
            if (esElMismo == 0) {
                c = clientes.get(i);
                break;
            }
        }
        if (encontrado == false) {
            c = null;
        }
        return c;
    }

}
