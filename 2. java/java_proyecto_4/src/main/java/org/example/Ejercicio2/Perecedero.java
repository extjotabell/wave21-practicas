package org.example.Ejercicio2;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadProductos) {
        double precio = super.calcular(cantidadProductos);

        if(diasPorCaducar == 3){
            precio = precio/2;
        } else if(diasPorCaducar == 2){
            precio = (precio/2)/2;
        } else if(diasPorCaducar == 1){
            precio = ((precio/2)/2)/2;
        }

        return precio;
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
}
