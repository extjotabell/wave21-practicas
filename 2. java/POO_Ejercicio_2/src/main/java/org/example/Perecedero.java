package org.example;

public class Perecedero extends Producto{
    private int diasPorCaducar;


    public Perecedero(int diasPorCaducar, String nombre, double precio) {
//        se invoca el constructor de la superclase
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

//    sobreescribir el metodo calcular
    @Override
    public double calcular(int cantidadDeProductos) {
        double precioFinal = super.calcular(cantidadDeProductos);
        switch (this.diasPorCaducar) {
            case 1 -> precioFinal /= 4;
            case 2 -> precioFinal /= 3;
            case 3 -> precioFinal /= 2;
        }
        return precioFinal;
    }
}
