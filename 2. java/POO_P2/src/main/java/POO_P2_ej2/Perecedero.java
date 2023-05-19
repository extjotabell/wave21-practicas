package POO_P2_ej2;

public class Perecedero extends Producto{
    private int diasPorCaducar;

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){

        double precioConDescuento = precio * cantidadDeProductos;
        if(diasPorCaducar == 1){
            precioConDescuento = precioConDescuento / 4;
        }else if ( diasPorCaducar == 2){
            precioConDescuento = precioConDescuento / 3;
        }else if ( diasPorCaducar == 3){
            precioConDescuento = precioConDescuento / 2;
        }
        return precioConDescuento;
    }

    @Override
    public String toString() {
        return "Este producto es " + nombre + " y cuesta " + precio + ". Es perecedero, caducara en " + diasPorCaducar + " días";
    }
}
