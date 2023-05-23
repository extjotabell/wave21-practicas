package Ejercicio_2.clases;

import Ejercicio_2.interfaces.Imprimible;

public class Curriculum implements Imprimible {
    private Persona persona;

    public Curriculum(Persona persona) {
        this.persona = persona;
    }

    @Override
    public void imprimir() {
        Persona per = this.getPersona();
        System.out.println(String.format("Persona:\nNombre: %s\nApellido: %s\nEdad: %d\nHabilidades: ", per.getNombre(), per.getApellido(),per.getEdad()));
        for (String habilidad: per.getHabilidades()){
            System.out.println(String.format(" %s,",habilidad));
        }
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
}
