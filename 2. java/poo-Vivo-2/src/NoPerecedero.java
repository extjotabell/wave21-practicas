public class NoPerecedero extends Producto{
    private String tipo;

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NoPerecedero(double precio, String nombre, String tipo) {
        super(precio, nombre);
        this.tipo = tipo;
    }
}
