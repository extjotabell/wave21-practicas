package supermercado;

import java.util.ArrayList;
import java.util.HashMap;

public class Supermercado {
    private HashMap<String,Cliente> clientes;
    private ArrayList<Factura> facturas;

    public Supermercado(){
        clientes = new HashMap<>();
        facturas = new ArrayList<>();
    }

    public void agregar(Cliente cliente){
        clientes.put(cliente.obtenerDni(), cliente);

    }

    public Cliente buscar(String dni){
        return clientes.get(dni);
    }

    public void eliminar(String dni){
        clientes.remove(dni);
    }

    public void imprimirClientes(){
        clientes.values().forEach(Cliente::mostrar);
    }

    public void agregar(Factura factura){
        if(factura.esAgregable(clientes)){
            facturas.add(factura);
            System.out.println("Se pudo agregar la factura");

        }else{
            System.out.println("No se pudo agregar la factura");
        }
    }
}

