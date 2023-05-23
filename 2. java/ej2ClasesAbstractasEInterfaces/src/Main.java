import clases.*;
import interfaces.Imprimir;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Persona persona= new Persona();
        persona.setApellido("Gutierrez");
        persona.setNombre("Juan");
        persona.setDni("32423432");
        persona.setEdad(18);
        Habilidad habilidad = new Habilidad();
        habilidad.setDescripcion("Java");
        Habilidad habilidad2= new Habilidad();
        habilidad2.setDescripcion("Spring");
        Curriculum curriculum= new Curriculum(persona, Arrays.asList(habilidad,habilidad2));
        LibrosPDF librosPDF= new LibrosPDF(300,"UnlibroLindo","UnlibroLindo","Terror");
        Informes informes= new Informes("JSOIajsoiajioso",43,"Borges","Warren Buffet");

        curriculum.imprimir();
        librosPDF.imprimir();
        informes.imprimir();
    }
}