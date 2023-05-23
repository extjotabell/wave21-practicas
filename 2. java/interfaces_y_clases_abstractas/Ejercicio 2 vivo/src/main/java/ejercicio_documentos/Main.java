package ejercicio_documentos;


import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Juan",23,"juan@gmail.com");
        Persona persona2 = new Persona("Pedro",23,"pedro@gmail.com");
        ArrayList<String> habilidades = new ArrayList<>();

        habilidades.add("Trabajador");
        habilidades.add("Pensamiento lateral");

        Imprimible curriculum = new Curriculum(persona,habilidades);
        Imprimible pdf = new LibroPdf(100, persona, "El mejro libro", "Aventura");
        Imprimible informe = new Informes("Un informe corto", persona, persona2);

        ArrayList<Imprimible> imprimibles = new ArrayList<>();
        imprimibles.add(curriculum);
        imprimibles.add(pdf);
        imprimibles.add(informe);

        for (Imprimible imprimible: imprimibles) {
            imprimible.imprimir();
        }

    }
}
