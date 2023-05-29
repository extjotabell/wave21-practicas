package org.parteI.logic;

import org.parteI.model.Cliente;
import org.parteI.model.Item;
import java.util.List;

public interface iFacturaCliente {
    void crearFactura(long codigo, Cliente cliente, List<Item> listaProducto);
    void consultarFacturas();
    void consultarFacturas(long codigo);
    void eliminarFactura(long codigo);
    void actualizarFactura(long codigo, Cliente cliente, List<Item> listaProducto, double totalCompra);


}
