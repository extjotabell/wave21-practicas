import java.util.List;

public class Curriculums implements Imprimible{
    public String nombre;
    public int edad;
    public List<String> habilidades;

    @Override
    public void imprimir() {
        System.out.println("\nNombre: " + this.nombre + "\nEdad: " + this.edad);
        for(int i = 0; i < this.habilidades.size() ; i++){
            System.out.println("\nHabilidad:" + this.habilidades.get(i));
        }
    }

    //Constructs, getters, setter
    public Curriculums(String nombre, int edad, List<String> habilidades) {
        this.nombre = nombre;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

}
