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


    @Override
    public double calcular(double precio, int cantidadDeProductos){
        double precioSinDescuento = super.calcular(precio, cantidadDeProductos);
        if(this.diasPorCaducar == 1 ) {
            return precioSinDescuento / 4;
        }else if(this.diasPorCaducar == 2 ) {
            return precioSinDescuento / 3;
        }else if (this.diasPorCaducar == 3 ) {
            return precioSinDescuento/2 ;
        }else {
            return precioSinDescuento;
        }
    }


}
