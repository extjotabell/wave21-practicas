package ejercicio_documentos;

import java.util.ArrayList;

public class Curriculum implements Imprimible{
    private Persona persona;
    private ArrayList<String> habilidades;

    public Curriculum(Persona persona, ArrayList<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println( "Curriculum de" +
                 persona.toString() +
                ", con habilidades:" + habilidades );
    }
}
