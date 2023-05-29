package models;

import repository.Socorrista;

public class SocorristaMoto implements Socorrista<Moto> {
    @Override
    public void socorrer(Moto obj) {
        System.out.println("Socorriendo moto " + obj.getPatente());
    }
}
