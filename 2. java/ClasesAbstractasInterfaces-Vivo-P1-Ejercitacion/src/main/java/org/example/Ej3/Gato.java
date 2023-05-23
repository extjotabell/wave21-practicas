package org.example.Ej3;

public class Gato extends Animal implements ICarnivoro{

    private String nombre;

    public Gato(String nombre) {
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
        System.out.println("El gato " +this.nombre+ " hace miau");
    };

    public String comerCarne(){
        return ("Yo como carne, no vives de ensalada");
    };
}
