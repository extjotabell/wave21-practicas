package EjercicioDistribuidora;

public class Perecedero extends Producto{
    public Perecedero(String nombre, double precio, int diasPorCaducar) {
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
    public double calcular(int cantidadDeProductos) {
        return switch (diasPorCaducar) {
            case 1 -> super.calcular(cantidadDeProductos) / 4;
            case 2 -> super.calcular(cantidadDeProductos) / 3;
            case 3 -> super.calcular(cantidadDeProductos) / 2;
            default -> super.calcular(cantidadDeProductos);
        };
    }

    @Override
    public String toString() {
        return super.toString() + " Dias hasta caducar: " + this.diasPorCaducar;
    }

    private int diasPorCaducar;
}
