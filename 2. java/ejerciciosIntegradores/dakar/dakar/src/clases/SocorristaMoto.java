package clases;

public class SocorristaMoto extends Vehiculo{

    public SocorristaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000, 4);
    }

    public void socorrer(Moto unaMoto){
        System.out.println("Socorriendo moto: " + unaMoto.getPatente());
    }
}
