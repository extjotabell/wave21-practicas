package clases;

import interfaces.Imprimir;

import java.util.List;

public class Curriculum implements Imprimir {

    private Persona persona;
    private List<Habilidad> habilidades;

    public Curriculum(Persona persona, List<Habilidad> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<Habilidad> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<Habilidad> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Curriculum{" +
                persona.toString() +
                habilidades.toString() +
                '}';
    }
}
