package Ejercicio2;

import java.util.List;

public class Curriculum implements Documento{
    private Persona persona;
    private List<String> listaHabilidades;

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }

    public List<String> getListaHabilidades() {
        return listaHabilidades;
    }

    public void setListaHabilidades(List<String> listaHabilidades) {
        this.listaHabilidades = listaHabilidades;
    }

    public Curriculum(Persona persona, List<String> listaHabilidades) {
        this.persona = persona;
        this.listaHabilidades = listaHabilidades;
    }

    @Override
    public String imprimir()  {
        String mensaje = "Ejercicio2.Curriculum de: " + persona.getNombre() + " " + persona.getApellido();
        mensaje += ". Habilidades: ";
        for(int i = 0; i < listaHabilidades.size(); i++){
            mensaje += listaHabilidades.get(i) + ",";
        }
        return mensaje;
    }
}
