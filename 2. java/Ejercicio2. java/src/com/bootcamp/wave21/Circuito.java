package com.bootcamp.wave21;

public class Circuito {

    private int id;
    private String descripcion;
    private String nombre;
    private double monto_mayor;
    private double monto_menor;
    private boolean habilitada_menores;

    public boolean isHabilitada_menores() {
        return habilitada_menores;
    }

    public void setHabilitada_menores(boolean habilitada_menores) {
        this.habilitada_menores = habilitada_menores;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getMonto_mayor() {
        return monto_mayor;
    }

    public void setMonto_mayor(double monto_mayor) {
        this.monto_mayor = monto_mayor;
    }

    public double getMonto_menor() {
        return monto_menor;
    }

    public void setMonto_menor(double monto_menor) {
        this.monto_menor = monto_menor;
    }
}
