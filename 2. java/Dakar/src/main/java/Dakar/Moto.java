package Dakar;

public class Moto extends Vehiculo {

    public Moto() {
    }

    public Moto(int aceleracion, int velocidad, int anguloDeGiro, String patente) {
        super(aceleracion, velocidad, anguloDeGiro, patente);
        this.setPeso(300);
        this.setRuedas(2);
    }
}
