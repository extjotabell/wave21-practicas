package Ejercicio_3;

import Ejercicio_3.clases.Gato;
import Ejercicio_3.clases.Perro;
import Ejercicio_3.clases.Vaca;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro("Antonio");
        Gato gato = new Gato("Michi");
        Vaca vaca = new Vaca("Lola");
        vaca.comerHierba();
        System.out.println(String.format("El perro %s",perro.getNombre()));
        perro.comerAnimal(vaca);
        perro.comerCarne();
    }
}
