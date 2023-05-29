package models;

import repository.Socorrista;

public class SocorristaAuto implements Socorrista<Auto> {
    @Override
    public void socorrer(Auto obj) {
        System.out.println("Socorriendo auto " + obj.getPatente());
    }
}
