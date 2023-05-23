package com.bootcamp.wave21;
import java.util.List;

public class Curriculum extends TipoDocumento{

    /*incluye a una persona con todos sus atributos más una lista de sus habilidades.*/
    private Persona persona;
    private List<Habilidad> habilidades;

    public Curriculum() {
    }

    public Curriculum(Persona persona) {
        this.persona = persona;
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
    public String toString() {
        return "Curriculum{" +
                "persona=" + persona +
                ", habilidades=" + habilidades +
                '}';
    }

    public String mostrarFormatoImprimible(){
        return this.toString();
    }
}
