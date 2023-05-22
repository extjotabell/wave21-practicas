package Clases;

public class NoPerecedero extends Producto {
    String tipo;
    public NoPerecedero(double precio, String nombre, String tipo) {
        super(nombre, precio);
        tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Tipo: '" + tipo + '\'';
    }
}
