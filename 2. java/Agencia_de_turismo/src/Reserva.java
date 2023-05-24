public abstract class Reserva {
    private Double costo;

    public Reserva(Double costo){
        this.costo=costo;
    }

    public Double getCosto(){
        return this.costo;
    }

}
