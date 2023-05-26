package EjercicioVivo2b;

public class Auto extends  Vehiculo{
    public Auto(int velocidad, int aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.peso = 1000;
        this.ruedas =4;
    }
}
