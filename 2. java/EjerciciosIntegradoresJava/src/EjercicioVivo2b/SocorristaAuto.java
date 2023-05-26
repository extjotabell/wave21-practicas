package EjercicioVivo2b;

public class SocorristaAuto  extends  Vehiculo{
    public SocorristaAuto(int velocidad, int aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.peso = 1000;
        this.ruedas = 4;
    }

    public void socorrer(Auto unAuto){
        System.out.println("Socorriendo auto: " + unAuto.patente);
    }
}
