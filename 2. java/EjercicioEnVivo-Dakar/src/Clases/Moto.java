package Clases;

public class Moto extends Vehiculo{
    private static final double PESO_CONSTANTE = 300;
    private static final int RUEDAS_CONSTANTE = 2;
    public Moto() {
        setPeso(PESO_CONSTANTE);
        setRuedas(RUEDAS_CONSTANTE);
    }

    public Moto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_CONSTANTE, RUEDAS_CONSTANTE);
    }
}
