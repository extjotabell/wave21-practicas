package clases;

public class SocorristaMoto extends Vehiculo{
    public SocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente);
        this.peso = 700;
        this.ruedas = 4;
    }

    public void socorrer(Moto moto){
        System.out.println("Socorriendo moto " + moto.patente);
    }
}
