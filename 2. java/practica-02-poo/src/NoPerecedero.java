public class NoPerecedero extends Producto{
    String tipo;

    public NoPerecedero(String nombre, Double precio) {
        super(nombre, precio);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
