package supermercado;

public class Item {
    private int codigo;
    private int cantidad;
    private double costoUnitario;
    private String nombre;

    public Item(int codigo, int cantidad, double costoUnitario, String nombre) {
        this.codigo = codigo;
        this.cantidad = cantidad;
        this.costoUnitario = costoUnitario;
        this.nombre = nombre;
    }
}
