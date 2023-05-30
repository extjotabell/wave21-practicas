package model;

public class Socorrista <T extends Vehiculo>{

    public void socorrer(T objeto){
        System.out.println("Socorriendo " + objeto.getClass() + "----->>");
        System.out.println("Patente" + objeto.getPatente());
    }

}
