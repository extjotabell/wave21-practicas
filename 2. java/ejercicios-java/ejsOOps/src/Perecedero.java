public class Perecedero extends Producto{
    int diasPorCaducar;

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(String nombre, double precio, int diasPorCaducar) {
        super(nombre, precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos){
        double calculoBase = this.precio * cantidadDeProductos;
        if(this.diasPorCaducar == 1){
            calculoBase = calculoBase/4;
        } else if (this.diasPorCaducar == 2) {
            calculoBase = calculoBase/3;
        }else{
            calculoBase = calculoBase/2;
        }
        return calculoBase;
    }
}
