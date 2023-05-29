package Ejercicio;

import java.util.ArrayList;
import java.util.List;

public class Crud_Factura implements CRUD<Factura, Integer>{
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
    public boolean eliminarElemento(Integer elemento) {
        try
        {
            if(buscarElemento(elemento, facturas) != null){
                Factura c = buscarElemento(elemento, facturas);
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
        try {
            Factura f = buscarElemento(elemento.getId(), facturas);
            f.setId(elemento.getId());
            f.setCliente(elemento.getCliente());
            f.setItems(elemento.getItems());
            f.setTotalCompra(elemento.getTotalCompra());
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }

    @Override
    public Factura consultarElemento(Integer elemento) {
        return buscarElemento(elemento, facturas);
    }

    public Factura buscarElemento (int id, List<Factura> facturas)
    {
        Factura c = null;
        boolean encontrado = false;
        for (int i = 0; i < facturas.size(); i++) {
            int idFactura = facturas.get(i).getId();
            if (idFactura == id) {
                c = facturas.get(i);
                break;
            }
        }
        if (encontrado == false) {
            c = null;
        }
        return c;
    }
}
