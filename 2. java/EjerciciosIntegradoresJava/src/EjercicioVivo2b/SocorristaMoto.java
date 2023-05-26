package EjercicioVivo2b;

public class SocorristaMoto extends Vehiculo{

    public SocorristaMoto(int velocidad, int aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.peso = 300;
        this.ruedas=2;
    }

    public void socorrer(Moto unaMoto){
        System.out.println("Socorriendo moto: " + unaMoto.patente);
    }
}
