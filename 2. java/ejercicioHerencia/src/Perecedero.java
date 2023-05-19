public class Perecedero extends Producto{
    private int diasPorCaducar;

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
    public double calcular(int cantidadProductos) {
        switch (this.diasPorCaducar){
            case 1:
                return super.calcular(cantidadProductos)-this.precio*1/4;
            case 2:
                return super.calcular(cantidadProductos)-this.precio*1/3;
            case 3:
                return super.calcular(cantidadProductos)-this.precio*1/2;
        }
        return super.calcular(cantidadProductos);
    }
}
