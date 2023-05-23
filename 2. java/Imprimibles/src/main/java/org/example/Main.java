package org.example;

import java.util.Arrays;
import java.util.List;

public class Main {
  public static void main(String[] args) {
    List<Imprimible> documentos = Arrays.asList(
      new Curriculum("Nahuel", "De Bellis", "debellisnahuel@gmail.com", Arrays.asList(Habilidades.NOSE)),
      new Pdf(10, "Juan", "Guerra", "Terror"),
      new Informes("Juan", "Nahuel", "Mucho", 10)
    );

    documentos.forEach(Main::impresora);
  }

  public static void impresora(Imprimible i) {
    i.imprimir();
  }
}