package EjercicioDistribuidora;

public class NoPerecedero extends Producto{

    public NoPerecedero(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return super.toString() + " de tipo: " + this.tipo;
    }

    private String tipo;
}
