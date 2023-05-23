import java.util.List;

public class Curriculum implements Documento {
    private Persona persona;
    private List<String> habilidades;

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

    public Curriculum(Persona persona, List<String> habilidades) {
        this.persona = persona;
        this.habilidades = habilidades;
    }

    public void agregarHabilidad(String habilidad){
        habilidades.add(habilidad);
    }

    @Override
    public String imprimir() {
        return "Nombre: " + persona.getNombre() + " Apellido: " + persona.getApellido() + " Habilidades: " +
                habilidades.toString();
    }
}
