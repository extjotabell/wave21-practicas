public abstract class Reserva {
    private Double costo;
    private String nombre;

    public Reserva(Double costo){
        this.costo=costo;
    }

    public Double getCosto(){
        return this.costo;
    }

    public String getNombre(){
        return this.nombre;
    }

    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "costo=" + costo +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
