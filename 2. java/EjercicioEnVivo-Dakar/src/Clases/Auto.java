package Clases;

public class Auto extends Vehiculo{
    private static final double PESO_CONSTANTE = 1000;
    private static final int RUEDAS_CONSTANTE = 4;
    public Auto() {
        setPeso(PESO_CONSTANTE);
        setRuedas(RUEDAS_CONSTANTE);
    }

    public Auto(double velocidad, double aceleracion, double anguloDeGiro, String patente){
        super(velocidad, aceleracion, anguloDeGiro, patente, PESO_CONSTANTE, RUEDAS_CONSTANTE);
    }
}
