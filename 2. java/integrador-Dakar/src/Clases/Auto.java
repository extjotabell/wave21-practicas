package Clases;

import Interfaces.SocorristaAuto;

public class Auto extends Vehiculo implements SocorristaAuto {


    public Auto(Double velocidad, Double aceleracion, Double anguloDeGiro,
                String patente) {
        super(velocidad, aceleracion, anguloDeGiro, patente, 1000.0 , 4);
    }


    @Override
    public void socorrer(Auto unAuto){
        System.out.println("Socorriendo auto: "+ this.getPatente());
    }
}
