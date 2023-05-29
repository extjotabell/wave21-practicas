package Ejercicio;

import java.util.ArrayList;
import java.util.List;

public class CrudItem implements CRUD<Item, String>{
   public List<Item> items = new ArrayList<>();
    @Override
    public boolean agregarElemento(Item elemento) {
        try
        {
            items.add(elemento);
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
            if(buscarElemento(elemento, items) != null){
                Item c = buscarElemento(elemento, items);
                items.remove(c);
            }
            return true;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    @Override
    public boolean actualizarElemento(Item elemento) {
        try {
            Item i = buscarElemento(elemento.getCodigo(), items);
            i.setCodigo(elemento.getCodigo());
            i.setCostoUnitario(elemento.getCostoUnitario());
            i.setNombre(elemento.getNombre());
            i.setCantidadComprada(elemento.getCantidadComprada());
            return true;
        }
        catch (Exception e)
        {
            return false;
        }

    }

    @Override
    public Item consultarElemento(String elemento) {
        return buscarElemento(elemento, items);
    }

    public Item buscarElemento (String codigoP, List<Item> items)
    {
        Item c = null;
        boolean encontrado = false;
        for (int i = 0; i < items.size(); i++) {
            String codigo = items.get(i).getCodigo();
            int esElMismo = codigo.compareToIgnoreCase(codigoP);
            if (esElMismo == 0) {
                c = items.get(i);
                break;
            }
        }
        if (encontrado == false) {
            c = null;
        }
        return c;
    }
}
