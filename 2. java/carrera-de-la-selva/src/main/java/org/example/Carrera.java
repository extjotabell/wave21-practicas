package org.example;

import org.circuitos.Circuito;
import org.circuitos.avanzado.CircuitoAvanzado;
import org.circuitos.chico.CircuitoChico;
import org.circuitos.forfun.CircuitoForFun;
import org.circuitos.medio.CircuitoMedio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Carrera {
  List<Inscripcion> inscripciones = new ArrayList<>();
  Circuito circuitoChico = new CircuitoChico(
    100,
    "chico",
    "2km por selva y arroyos"
  );

  Circuito circuitoForFun = new CircuitoForFun(
    100,
    "for fun",
    "22km por selva y arroyos"
  );

  Circuito circuitoMedio = new CircuitoMedio(
    101,
    "medio",
    "5km por selva, arroyos y barro"
  );

  Circuito circuitoAvanzado = new CircuitoAvanzado(
    102,
    "avanzado",
    "10km por selva, arroyos, barro y escalada por piedra"
  );

  public Carrera() { }
  public void abrirInscripcion() {

    List<Participante> participantes = this.crearParticipantes();

    for(int i=1000;i<1010;++i){
      Inscripcion inscripcion = new Inscripcion(i, this.circuitoForFun, participantes.get(i%participantes.size()));
      this.inscripciones.add(inscripcion);
    }

    for(int i=1010;i<1020;++i){
      Inscripcion inscripcion = new Inscripcion(i, this.circuitoMedio, participantes.get(i%participantes.size()));
      this.inscripciones.add(inscripcion);
    }

    for(int i=1020;i<1030;++i){
      Inscripcion inscripcion = new Inscripcion(i, this.circuitoAvanzado, participantes.get(i%participantes.size()));
      this.inscripciones.add(inscripcion);
    }

    for(int i=0;i<this.inscripciones.size();i+=4){
      Inscripcion inscripcion = this.inscripciones.get(i);
      //inscripcion.invalidarInscripcion();
    }

  }

  public void informeCierre() {
    float totalCicuitoChico = 0;
    float totalCicuitoMedio = 0;
    float totalCicuitoAvanzado = 0;

    System.out.println("Listado general");
    for(int i=0;i<this.inscripciones.size();++i){
      Inscripcion inscripcion = this.inscripciones.get(i);
      if(inscripcion.esValido()) {
        String participante = inscripcion.getParticipanteInfo();

        String cartelInfo = String.format(
          "Inscripcion a circuito %s numero: %s a nombre de %s por: $%s",
          inscripcion.getCategoria().getNombre(),
          inscripcion.getId(),
          participante,
          inscripcion.getMonto()
        );

        System.out.println(cartelInfo);
      }
    }

    System.out.println("Listado por Categoria Circuito for fun");
    for(int i=0;i<this.inscripciones.size();++i) {
      Inscripcion inscripcion = this.inscripciones.get(i);
      if(inscripcion.esValido() && inscripcion.getCategoria().getId() == this.circuitoForFun.getId()) {

        String participante = inscripcion.getParticipanteInfo();

        totalCicuitoChico += inscripcion.getMonto();
        String cartelInfo = String.format(
          "Inscripcion n: %s a nombre de %s por: $%s",
          inscripcion.getId(),
          participante,
          inscripcion.getMonto()
        );

        System.out.println(cartelInfo);
      }
    }

    System.out.println("Listado por Categoria Circuito Medio");
    for(int i=0;i<this.inscripciones.size();++i) {
      Inscripcion inscripcion = this.inscripciones.get(i);
      if(inscripcion.esValido() && inscripcion.getCategoria().getId() == this.circuitoMedio.getId()) {
        String participante = inscripcion.getParticipanteInfo();

        totalCicuitoMedio += inscripcion.getMonto();
        String cartelInfo = String.format(
          "Inscripcion n: %s a nombre de %s por: $%s",
          inscripcion.getId(),
          participante,
          inscripcion.getMonto()
        );

        System.out.println(cartelInfo);
      }
    }

    System.out.println("Listado por Categoria Circuito Avanzado");
    for(int i=0;i<this.inscripciones.size();++i) {
      Inscripcion inscripcion = this.inscripciones.get(i);
      if(inscripcion.esValido() && inscripcion.getCategoria().getId() == this.circuitoAvanzado.getId()) {
        String participante = inscripcion.getParticipanteInfo();

        totalCicuitoAvanzado += inscripcion.getMonto();
        String cartelInfo = String.format(
          "Inscripcion n: %s a nombre de %s por: $%s",
          inscripcion.getId(),
          participante,
          inscripcion.getMonto()
        );

        System.out.println(cartelInfo);
      }
    }

    String informesTotales = String.format(
      "Total recaudado: %s\nTotal Circuito Chico: %s\nTotal Circuito Medio: %s\nTotal Circuito Avanzaado: %s",
      totalCicuitoMedio+totalCicuitoChico+totalCicuitoAvanzado,
      totalCicuitoChico,
      totalCicuitoMedio,
      totalCicuitoAvanzado
    );
    System.out.println(informesTotales);
  }

  private List<Participante> crearParticipantes() {
    return Arrays.asList(
      new Participante(10, 12340525, "Nahuel", "De bellis", 22, "11-2399-5157", "11-1111-111", "A+"),
      new Participante(11, 12340496, "Martin", "De bellis", 12, "11-2399-5157", "11-1111-111", "A+"),
      new Participante(12, 12340615, "Juan", "De Bellis", 12, "11-2399-5157", "11-1111-111", "A+"),
      new Participante(13, 32340495, "Ernesto", "De Bellis", 32, "11-2399-5157", "11-1111-111", "A+"),
      new Participante(14, 32340490, "Gabriela", "De Bellis", 42, "11-2399-5157", "11-1111-111", "A+"),
      new Participante(15, 32340503, "Silvina", "De Bellis", 12, "11-2399-5157", "11-1111-111", "A+"),
      new Participante(16, 42340512, "Luciano", "De Bellis", 12, "11-2399-5157", "11-1111-111", "A+"),
      new Participante(17, 42340501, "Graciela", "De Bellis", 12, "11-2399-5157", "11-1111-111", "A+"),
      new Participante(18, 52340587, "Osvaldo", "De Bellis", 18, "11-2399-5157", "11-1111-111", "A+"),
      new Participante(19, 52340472, "German", "De Bellis", 18, "11-2399-5157", "11-1111-111", "O+")
    );
  }

  private boolean validarInscripcionUnica(Participante p) {
    for(Inscripcion i : this.inscripciones)
      if(i.getParticipante().getId() == p.getId())
        return true;
    return false;
  }
}
