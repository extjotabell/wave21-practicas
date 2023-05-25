package Ejercicio3;

public abstract class Animal {
    private String sonido;


    public String getSonido() {
        return sonido;
    }


    public void setSonido(String sonido) {
        this.sonido = sonido;
    }

    public abstract String mostrarSonido ();

    public abstract void comerAnimal(Animal a);

}
