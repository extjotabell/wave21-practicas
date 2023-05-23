package org.example;

import org.circuitos.Circuito;
import org.circuitos.avanzado.CircuitoAvanzado;
import org.circuitos.chico.CircuitoChico;
import org.circuitos.forfun.CircuitoForFun;
import org.circuitos.medio.CircuitoMedio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Carrera {
  List<Inscripcion> inscripciones = new ArrayList<>();
  static final List<Participante> participantes = Arrays.asList(
    new Participante(10, 12340525, "Nahuel", "De bellis", 22, "11-2399-5157", "11-1111-111", "A+"),
    new Participante(11, 12340496, "Martin", "De bellis", 12, "11-2399-5157", "11-1111-111", "A+"),
    new Participante(12, 12340615, "Juan", "De Bellis", 12, "11-2399-5157", "11-1111-111", "A+"),
    new Participante(13, 32340495, "Ernesto", "De Bellis", 32, "11-2399-5157", "11-1111-111", "A+"),
    new Participante(14, 32340490, "Gabriela", "De Bellis", 42, "11-2399-5157", "11-1111-111", "A+"),
    new Participante(15, 32340503, "Silvina", "De Bellis", 12, "11-2399-5157", "11-1111-111", "A+"),
    new Participante(16, 42340512, "Luciano", "De Bellis", 12, "11-2399-5157", "11-1111-111", "A+"),
    new Participante(17, 42340501, "Graciela", "De Bellis", 12, "11-2399-5157", "11-1111-111", "A+"),
    new Participante(18, 52340587, "Osvaldo", "De Bellis", 18, "11-2399-5157", "11-1111-111", "O+"),
    new Participante(19, 52340472, "German", "De Bellis", 18, "11-2399-5157", "11-1111-111", "O+")
  );

  List<Circuito> circuitos = Arrays.asList(
    new CircuitoChico( 100, "chico", "2km por selva y arroyos" ),
    new CircuitoMedio( 101, "medio", "5km por selva, arroyos y barro" ),
    new CircuitoAvanzado( 102, "avanzado", "10km por selva, arroyos, barro y escalada por piedra" ),
    new CircuitoForFun( 103, "for fun", "22km por selva y arroyos" )
  );

  public Carrera() { }
  public void abrirInscripcion() {
    this.llenarInscripciones(1000, 1010, this.circuitos.get(0));
    this.llenarInscripciones(1010, 1020, this.circuitos.get(1));
    this.llenarInscripciones(1020, 1030, this.circuitos.get(2));
    this.llenarInscripciones(1030, 1040, this.circuitos.get(3));
  }

  private void llenarInscripciones(int indexInicio, int indexFinal, Circuito c) {
    for(int i=indexInicio;i<indexFinal;++i){
      Inscripcion inscripcion = new Inscripcion(i, c, Carrera.participantes.get(i%Carrera.participantes.size()));
      this.inscripciones.add(inscripcion);
    }
  }

  public void informeCierre() {
    float total = 0;

    for(Circuito circuito : circuitos) {
      float totalCircuito = 0;

      float totalFuncionalWay = inscripciones
        .stream()
        .filter(i -> i.esValido() && i.getCategoria().getId() == circuito.getId())
        .map(i -> i.getMonto())
        .reduce(0f, (sum, aa) -> sum+aa);

      for(Inscripcion inscripcion : inscripciones) {

        if(inscripcion.esValido() && inscripcion.getCategoria().getId() == circuito.getId()) {
          String participante = inscripcion.getParticipanteInfo();
          totalCircuito += inscripcion.getMonto();

          System.out.println(String.format(
            "Inscripcion a circuito %s numero: %s a nombre de %s por: $%s",
            inscripcion.getCategoria().getNombre(),
            inscripcion.getId(),
            participante,
            inscripcion.getMonto()
          ));
        }
      }

      System.out.println("Total circuito "+circuito.getNombre()+": "+totalCircuito);
      total+=totalCircuito;
    }

    String informesTotales = String.format("Total recaudado: %s", total);
    System.out.println(informesTotales);
  }

  private boolean validarInscripcionUnica(Participante p) {
    for(Inscripcion i : this.inscripciones)
      if(i.getParticipante().getId() == p.getId())
        return true;
    return false;
  }

  public void invalidarInscripciones() {
    for(int i=0;i<this.inscripciones.size();i+=4){
      Inscripcion inscripcion = this.inscripciones.get(i);
      inscripcion.invalidarInscripcion();
    }
  }

}
