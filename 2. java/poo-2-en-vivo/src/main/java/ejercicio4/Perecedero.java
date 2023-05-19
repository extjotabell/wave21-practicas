package ejercicio4;

public class Perecedero extends Producto{

    //diasPorCaducar de tipo int,
    //override calcular
    private int diasPorCaducar;


    public Perecedero(String nombre, double precio, int cantidad, int diasPorCaducar) {
        super(nombre, precio, cantidad);
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero() {
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

    @Override
    public double calcular(int cantidadDeProductos){
        double precio = super.getPrecio();

        if(diasPorCaducar == 1){
            precio = precio * 0.25;
        } else if (diasPorCaducar == 2) {
            precio = precio * 0.33;
        } else if (diasPorCaducar == 3) {
            precio = precio * 0.5;
        }

        return precio * cantidadDeProductos;
    }
}
