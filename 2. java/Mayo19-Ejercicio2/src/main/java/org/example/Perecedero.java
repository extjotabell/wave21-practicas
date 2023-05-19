package org.example;

public class Perecedero extends Producto{

    private int diasPorCaducar;


    public Perecedero(String nombre, double precio,int diasPorCaducar){
        super(nombre,precio);
        this.diasPorCaducar = diasPorCaducar;
    }

    public String toString(){
        return "Perecedero {Días por calcular:"+this.diasPorCaducar +"}";
    }

    public int getDiasPorCaducar() {
        return diasPorCaducar;
    }

    public void setDiasPorCaducar(int diasPorCaducar) {
        this.diasPorCaducar = diasPorCaducar;
    }

    @Override
    public double calcular(int cantidadDeProductos) {

        if(this.diasPorCaducar==1){
            this.precio = this.precio/4;
        } else if (this.diasPorCaducar==2) {
            this.precio = this.precio/3;
        }else if (this.diasPorCaducar==3) {
            this.precio = this.precio/2;
        }

        return precio * cantidadDeProductos;

    }

}
