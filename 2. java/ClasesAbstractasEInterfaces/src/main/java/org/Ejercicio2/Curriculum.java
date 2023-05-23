package org.Ejercicio2;

import java.lang.annotation.Documented;
import java.util.List;

public class Curriculum implements Documento {
    Persona persona;
    List<String> habilidades;

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    public void imprimir() {
        System.out.println("Curriculum{" +
                "persona=" + persona +
                ", habilidades=" + habilidades +
                '}');
    }
}
