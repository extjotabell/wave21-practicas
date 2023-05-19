package ejercicio4;

public class NoPerecedero extends Producto{
    //tipo String
    private String tipo;

    public NoPerecedero(String nombre, double precio, int cantidad, String tipo) {
        super(nombre, precio, cantidad);
        this.tipo = tipo;
    }

    public NoPerecedero(String tipo) {
        this.tipo = tipo;
    }

    public NoPerecedero() {
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "NoPerecedero{" +
                "tipo='" + tipo + '\'' +
                '}';
    }
}
