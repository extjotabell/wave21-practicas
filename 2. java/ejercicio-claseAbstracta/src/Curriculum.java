import java.util.ArrayList;

public class Curriculum extends Persona implements Imprimible{
    private ArrayList<String> habilidades = new ArrayList<>();

    public ArrayList<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList<String> habilidades) {
        this.habilidades = habilidades;
    }

    public Curriculum(String nombre, String apellido, int edad, ArrayList<String> habilidades) {
        super(nombre, apellido, edad);
        this.habilidades = habilidades;
    }

    public void toOneString(){
        System.out.println("ACA IMPRIMO UN CURRICULUM");
    }
    @Override
    public void imprimir(){
        this.toOneString();
    }

}

