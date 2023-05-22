package Clases;

public class Perecedero extends Producto{

    int diasPorCaducar;
    public Perecedero(double precio, String nombre, int diasPorCaducar) {
        super(nombre, precio);
        diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Dias por caducar:" + diasPorCaducar;
    }
    @Override
    public double calcular(int cantidadDeProductos){
        switch (diasPorCaducar){
            case 1:
                precio = precio / 4;break;
            case 2:
                precio = precio / 3;break;
            case 3:
                precio = precio / 2;break;
        }
        return super.calcular(cantidadDeProductos);
    }
}
