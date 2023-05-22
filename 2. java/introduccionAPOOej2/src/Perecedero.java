public class Perecedero extends  Producto{

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

    public double  calcular(int cantidadDeProductos){
        double precioFinal = cantidadDeProductos * precio;
        if(diasPorCaducar == 1){
            return precio /4;
        }
        else if(diasPorCaducar == 2){
            return precio /3;
        }
        else{
            return precio /2;
        }
    }

}
