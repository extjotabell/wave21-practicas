public class Perecedero extends Producto{
    int diasPorCaducar;

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
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double precioSinRestar = cantidadDeProductos * this.getPrecio();

        switch(this.getDiasPorCaducar()){
            case 1: precioSinRestar = precioSinRestar / 4;
            break;
            case 2: precioSinRestar = precioSinRestar / 3;
            break;
            case 3: precioSinRestar = precioSinRestar / 2;
            break;
        }
        return precioSinRestar;
    }
}
