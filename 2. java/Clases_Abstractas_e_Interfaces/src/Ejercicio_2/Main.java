package Ejercicio_2;

import Ejercicio_2.clases.Curriculum;
import Ejercicio_2.clases.Informe;
import Ejercicio_2.clases.LibroPDF;
import Ejercicio_2.clases.Persona;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        LibroPDF libro = new LibroPDF(20, "Wilson", "Aprendiendo Java","Programacion");
        Informe informe = new Informe("Habia un vez ...", 50, "Wilson N", "Revision");
        Curriculum cv = new Curriculum(null);

        libro.imprimir(libro);
        Persona persona = new Persona("Demian","de la vega", 27, null);
        ArrayList<String> hb = new ArrayList<>();

        hb.add("Programar");
        hb.add("Correr");
        hb.add("Comer");
        persona.setHabilidades(hb);
        cv.setPersona(persona);
        cv.imprimir(cv);

        informe.imprimir(informe);
    }
}
