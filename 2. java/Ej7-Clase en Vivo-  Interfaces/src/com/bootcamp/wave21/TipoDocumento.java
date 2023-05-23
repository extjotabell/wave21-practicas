package com.bootcamp.wave21;

public abstract class  TipoDocumento implements Imprimible {

    public abstract String mostrarFormatoImprimible();

    @Override
    public void imprimir() {
        System.out.println("-----"+getClass().getName()+"----------");
        System.out.println(mostrarFormatoImprimible());
    }
}
