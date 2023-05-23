package org.example.Ej3;

public class Vaca extends Animal implements IHerviboro{
    private String nombre;

    public Vaca(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void emitirSonido(){
        System.out.println("La vaca "+this.nombre+ " hace muuu");
    };

    @Override
    public String comerHierba(){
        return("Yo como hierbas");
    };
}
