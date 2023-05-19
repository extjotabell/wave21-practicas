package POO_P2_ej2;

public class NoPerecedero extends Producto{
    private String tipo;

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
        return "Este producto es " + nombre + " y cuesta " + precio + ". No es perecedero, es de tiopo " + tipo;
    }
}
