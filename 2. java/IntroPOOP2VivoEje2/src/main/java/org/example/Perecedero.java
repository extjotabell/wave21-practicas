package org.example;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(int diasPorCaducar, String nombre, double precio) {
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

    public double calcular(int cantidadProd){
        double result = cantidadProd * getPrecio();

        switch (diasPorCaducar){
            case 1: result = result / 4;
            break;
            case 2: result = result / 3;
            break;
            case 3: result = result / 2;
            break;
        }

        return result;
    }
}
