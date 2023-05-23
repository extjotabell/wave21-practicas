import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible {

    Persona persona;
    List habilidadesPersona = new ArrayList<>();

    public Curriculum(Persona persona, List habilidadesPersona) {
        this.persona = persona;
        this.habilidadesPersona = habilidadesPersona;
    }

    @Override
    public void imprimir() {
        System.out.println("El curriculum pertenece a "+ this.persona.nombre + " " + this.persona.apellido + " de " + this.persona.edad + " años.");
        System.out.println("Sus habilidades son:");
        this.habilidadesPersona.forEach(habilidad->System.out.println("* " + habilidad));
    }
}
