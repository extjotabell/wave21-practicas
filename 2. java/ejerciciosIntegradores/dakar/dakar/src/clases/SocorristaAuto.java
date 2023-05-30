package clases;

public class SocorristaAuto extends Vehiculo {
    public SocorristaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }

    public void socorrer(Auto unAuto){
        System.out.println("Socorriendo auto: " + unAuto.getPatente());
    }
}
