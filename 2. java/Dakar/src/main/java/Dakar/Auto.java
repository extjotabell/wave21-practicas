package Dakar;

public class Auto extends Vehiculo{
    public Auto() {
    }

    public Auto(int aceleracion, int velocidad, int anguloDeGiro, String patente) {
        super(aceleracion, velocidad, anguloDeGiro, patente);
        this.setPeso(1000);
        this.setRuedas(4);
    }
}
