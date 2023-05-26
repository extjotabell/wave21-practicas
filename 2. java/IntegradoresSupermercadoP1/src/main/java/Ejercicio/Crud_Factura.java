package Ejercicio;

import java.util.ArrayList;
import java.util.List;

public class Crud_Factura implements CRUD<Factura>{
    public List<Factura> facturas = new ArrayList<>();
    @Override
    public boolean agregarElemento(Factura elemento) {
        try
        {
            facturas.add(elemento);
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean eliminarElemento(String elemento) {
        try
        {
            if(buscarElemento(elemento, facturas) != null){
                Cliente c = buscarElemento(elemento, facturas);
                facturas.remove(c);
            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean actualizarElemento(Factura elemento) {
        return false;
    }

    @Override
    public Factura consultarElemento(String elemento) {
        return null;
    }

    public Factura buscarElemento (String dni, List<Factura> facturas)
    {
        /*Factura c = null;
        boolean encontrado = false;
        for (int i = 0; i < facturas.size(); i++) {
            String dniCliente = facturas.get(i).get();
            int esElMismo = dniCliente.compareToIgnoreCase(dni);
            if (esElMismo == 0) {
                c = factuas.get(i);
                break;
            }
        }
        if (encontrado == false) {
            c = null;
        }
        return c;*/
        return null;
    }
}
