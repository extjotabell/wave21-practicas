public class Perecedero extends Producto{
    private int diasPorCaducar;

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    public Perecedero(double precio, String nombre, int diasPorCaducar) {
        super(precio, nombre);
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public String toString() {
        return "Perecedero{" +
                "diasPorCaducar=" + diasPorCaducar +
                '}';
    }

    @Override
    public double calcular(int cantidadDeProductos) {
        // IF
    /*
    Si le resta un día (1) para caducar, se reducirá 4 veces el precio final.
    Si le restan dos días (2) para caducar, se reducirá 3 veces el precio final.
    Si le restan 3 días (3) para caducar, se reducirá la mitad de su precio final.

     */
        double numRetorno = 0;
        double resultado = super.calcular(cantidadDeProductos);

        if (diasPorCaducar<=1){
            numRetorno = resultado/4;
        } else if (diasPorCaducar==2){
            numRetorno = resultado/3;
        } else if (diasPorCaducar==3){
            numRetorno = resultado/2;
        } else {
            numRetorno = resultado;
        };

        return  numRetorno;

    }


}
