public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDias_por_caducar() {
        return diasPorCaducar;
    }

    public void setDias_por_caducar(int dias_por_caducar) {
        this.diasPorCaducar = dias_por_caducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "dias_por_caducar=" + diasPorCaducar+
                '}';
    }

    @Override
    public double calcular(int cantidad) {
        double precioOriginal = super.calcular(cantidad);
        if (diasPorCaducar==1){
            precioOriginal = precioOriginal/4;
        } else if (diasPorCaducar==2) {
            precioOriginal = precioOriginal/3;
        } else if (diasPorCaducar==3) {
            precioOriginal = precioOriginal/2;
        }
        return precioOriginal;
    }
}