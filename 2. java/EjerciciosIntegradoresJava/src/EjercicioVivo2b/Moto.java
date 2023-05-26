package EjercicioVivo2b;

public class Moto extends Vehiculo{
    public Moto(int velocidad, int aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.peso = 300;
        this.ruedas =2;
    }
}
