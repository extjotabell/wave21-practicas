package PracticaPOO_Vivo2;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return super.toString() + " la cantidad de días para caducar es de: " + this.getDiasPorCaducar();
    }
    @Override
    public int calcular (int cantidadDeProductos) {
        int total = 0;
        switch (this.getDiasPorCaducar()) {
            case 1:
                total = (int)((this.getPrecio()* cantidadDeProductos) /4);
                break;
            case 2:
                total = (int)((this.getPrecio()* cantidadDeProductos) /3);
                break;
            case 3:
                total = (int)((this.getPrecio()* cantidadDeProductos) /2);
                break;
        }
        return total;
    }
}
