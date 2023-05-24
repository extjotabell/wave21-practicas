package Clases;

import java.util.ArrayList;
import java.util.List;

public class Localizador {
    private double total;
    private List<Producto> productos;


    private int id;

    public Localizador(int id) {
        this.total = 0D;
        this.id = id;
        this.productos = new ArrayList<>();
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void agregarProducto(Producto producto){
        this.productos.add(producto);
    }


    public void calcularTotal() {
        /*
        Si un cliente adquiere 2 reservas de hotel o 2 boletos de viaje, se aplicará un descuento de 5% en esas reservas.
         */

        long reservasHotel = productos.stream()
                                        .filter(x -> x instanceof Hotel)
                                        .count();

        long reservasBoletos = productos.stream()
                                            .filter(x -> x instanceof Boleto)
                                            .count();

        if ((reservasHotel > 1) || (reservasBoletos > 1)){
            productos
                    .forEach(
                            x -> {
                                if (x instanceof Hotel || x instanceof Boleto){
                                    x.setPrecio(x.getPrecio()*0.95);
                                }
                            }
                    );
        }

        total = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .sum();

        /*
        Si un cliente adquiere un paquete completo que consiste en reserva de hotel, comida,
        boletos de viajes, transporte, recibirá un descuento del 10% del total de la factura.
         */

        boolean existeRestaurant = productos.stream().anyMatch(x-> x instanceof Restaurant);
        boolean existeTransporte = productos.stream().anyMatch(x-> x instanceof Transporte);
        
        if (existeRestaurant && existeTransporte && (reservasBoletos > 0) && (reservasHotel > 0)){
            total = total * 0.90;
        }
    }

    public void calcularTotal(double descuento) {
        calcularTotal();
        total = total * descuento;
    }

}
