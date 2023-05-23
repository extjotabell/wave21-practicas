package org.example.Ej3;

public class Perro extends Animal implements ICarnivoro{

    private String nombre;

    public Perro(String nombre) {
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
        System.out.println("El perro "+ this.nombre+ " hace guau");
    };
    public String comerCarne(){
        return("Yo como carne, no vives de ensalada");
    };
}
