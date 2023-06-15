package Entity;
public class Auto extends Vehiculo {
    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000D, 4);
    }
}
