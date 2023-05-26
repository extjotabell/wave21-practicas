package Ejercicio;

public class Item {
    private String codigo;
    private String nombre;
    private int cantidadComprada;
    private int costoUnitario;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCantidadComprada(int cantidadComprada) {
        this.cantidadComprada = cantidadComprada;
    }

    public void setCostoUnitario(int costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCantidadComprada() {
        return cantidadComprada;
    }

    public int getCostoUnitario() {
        return costoUnitario;
    }

    public Item(String codigo, String nombre, int cantidadComprada, int costoUnitario) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.cantidadComprada = cantidadComprada;
        this.costoUnitario = costoUnitario;
    }
}
