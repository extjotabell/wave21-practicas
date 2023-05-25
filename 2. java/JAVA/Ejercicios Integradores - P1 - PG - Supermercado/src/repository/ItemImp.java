package repository;

import model.Factura;
import model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ItemImp implements CRUDRepository<Item>{

    List<Item> items = new ArrayList<Item>();
    @Override
    public void save(Item item) {
        items.add(item);
    }

    @Override
    public void mostrarPantalla() {
        if(items.isEmpty()){
            System.out.println("No hay Items en el sistema!");
        }
        for (Item i : items) {
            System.out.println(i.toString());
        }
    }

    @Override
    public Optional buscar(Long itemBuscado) {
        boolean flag = false;
        for (Item i: items) {
            if (i.getCodigo().equals(itemBuscado)) {
                System.out.println(i.toString());
                flag = true;
                return Optional.of(i);
            }
        }

        if (flag == false) {
            System.out.println("No se encontro el item!");
        }

        return Optional.empty();
    }

    @Override
    public void eliminar(Long itemBorrado) {
        Optional<Item> item = this.buscar(itemBorrado);

        if (item.isEmpty()) {
            System.out.println("No existe el item!");
        } else{
            items.remove(item.get());
            System.out.println("Item eliminado con éxito!");
        }
    }

    @Override
    public List traerTodos() {
        return items;
    }
}
