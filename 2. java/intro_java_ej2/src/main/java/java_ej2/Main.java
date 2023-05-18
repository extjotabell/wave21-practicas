package java_ej2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
      Categoria chico = new Categoria(1, "Circuito chico", "2 km por selva y arroyos");
      Categoria medio = new Categoria(2, "Circuito medio", "5 km por selva, arroyos y barro");
      Categoria avanzado = new Categoria(3, "Circuito avanzado", "10 km por selva, arroyos, barro y escalada en piedra");

      Participante juan = new Participante("Juan", 123, 23, 1, 124, "0+", "4747474747");
      Participante pedro = new Participante("Pedro", 123, 23, 2, 124, "0+", "4747474747");
      Participante fiona = new Participante("Fiona", 123, 23, 3, 124, "0+", "4747474747");
      Participante flor = new Participante("Flor", 123, 17, 4, 124, "0+", "4747474747");


      Inscripcion inscripcion_juan = new Inscripcion(chico, juan, 1);
      Inscripcion inscripcion_pedro = new Inscripcion(medio, pedro, 2);
      Inscripcion inscripcion_fiona = new Inscripcion(avanzado, fiona, 3);
      Inscripcion inscripcion_flor = new Inscripcion(medio, flor, 3);

      ArrayList<Inscripcion> inscripciones = new ArrayList<Inscripcion>();

      inscripciones.add(inscripcion_juan);
      inscripciones.add(inscripcion_fiona);
      inscripciones.add(inscripcion_flor);
      inscripciones.add(inscripcion_pedro);

      System.out.println("Estas personas estan inscriptas en el circuito medio: " );

      for (Inscripcion insripto :inscripciones) {
          if(insripto.categoria.id == medio.id){
            insripto.participante.mostrar();
          }
      }
    }
}
