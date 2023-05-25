package clases;

public class SocorristaAuto extends Vehiculo{
    public SocorristaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.peso = 700;
        this.ruedas = 4;
    }

    public void socorrer(Auto auto){
        System.out.println("Socorriendo Auto " + auto.patente);
    }
}
