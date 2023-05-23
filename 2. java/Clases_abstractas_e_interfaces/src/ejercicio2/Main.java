package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Documento informe = new Informes("Texto generico",20,"Jose Juan","Juan Jose");
        Documento pdf = new Pdf(92,"Gabriel García Marquez","Cien años de Soledad","Novela");

        List<String> habilidades = new ArrayList<String>();
        habilidades.add("trabajo en grupo");
        habilidades.add("puntualidad");
        habilidades.add("proactividad");
        Persona persona = new Persona("Maria",23);

        Curriculum curriculum = new Curriculum(persona,habilidades);

        List<Documento> documentos = new ArrayList<>();
        documentos.add(curriculum);
        documentos.add(pdf);
        documentos.add(informe);

        for (Documento documento:documentos) {
            documento.imprimir();
        }


    }
}