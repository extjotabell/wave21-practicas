package Clases;

import Interfaces.SocorristaMoto;

public class Moto extends Vehiculo implements SocorristaMoto {
    public Moto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 300.0, 2);
    }

    @Override
    public void socorrer(Moto unaMoto){
        System.out.println("Socorriendo Moto: "+ this.getPatente());
    }
}
