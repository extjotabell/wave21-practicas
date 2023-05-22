public class Perecedero extends Producto{

    int diasPorCaducar;

    public Perecedero(String nombre, Double precio,int diasPorCaducar) {
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
    public Double calcular(int cantidadDeProductos){
        Double resultado = 0.0;
        switch (diasPorCaducar){
            case 1:
                resultado = super.calcular(cantidadDeProductos)/4;
                break;
            case 2:
                resultado = super.calcular(cantidadDeProductos)/3;
                break;
            case 3:
                resultado =super.calcular(cantidadDeProductos)/2;
                break;
            default:
                resultado = super.calcular(cantidadDeProductos);
                break;
        }
        return resultado;
    }
}
