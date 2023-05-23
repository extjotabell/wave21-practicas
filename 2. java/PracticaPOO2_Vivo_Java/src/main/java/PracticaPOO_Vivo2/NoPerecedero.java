package PracticaPOO_Vivo2;

public class NoPerecedero extends Producto{
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public NoPerecedero(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + " y el tipo es: " + this.getTipo();
    }

    @Override
    public int calcular(int cantidadDeProductos) {
        int total = (int)(this.getPrecio() * cantidadDeProductos);
        return total;
    }
}
