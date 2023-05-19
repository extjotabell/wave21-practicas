package com.bootcamp.wave21;

public class NoPercedero extends Producto{

    /**
     * Crear la clase NoPerecedero,
     * la misma va a tener un atributo llamado tipo,
     * el mismo va a ser un String, crear setters, getters, constructor y método toString();
     * en esta clase el método calcular() va a hacer exactamente lo mismo que en la clase Producto.
     */

    private String tipo;

    public NoPercedero() {
    }
    public NoPercedero(String nombre, double precio, String tipo){
        super(nombre,precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.getNombre() +" Precio: " + this.getPrecio() +
                " tipo: '" + tipo ;

    }

}
