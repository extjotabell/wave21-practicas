package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
    String ciudadMax = "", ciudadMin = "";

    int tempMax = Integer.MIN_VALUE;
    int tempMin = Integer.MAX_VALUE;

    final String[] ciudades = {
      "Londres",
      "Madrid",
      "Nueva York",
      "Buenos Aires",
      "Asuncion",
      "Sao Pablo",
      "Lima",
      "Santiago de chile",
      "Lisboa",
      "Tokyo"
    };

    final int [][] temperaturas = {
      { -2, 33 },
      { -3, 32 },
      { -8, 27 },
      { 4, 37 },
      { 6, 42 },
      { 5, 43 },
      { -100, 39 },
      { -7, 26 },
      { -1, 32 },
      { -10, 35 }
    };

    for(int i=0;i<ciudades.length;++i) {

      if(tempMax < temperaturas[i][1]) {
        ciudadMax = ciudades[i];
        tempMax = temperaturas[i][1];
      }

      if(tempMin > temperaturas[i][0]) {
        ciudadMin = ciudades[i];
        tempMin = temperaturas[i][0];
      }
    }

    String respuestaMaxima = String.format(
				"La ciudad con mayor temperatura es %s con %s", ciudadMax, tempMax
		);
    String respuestaMinima = String.format(
				"La ciudad con menor temperatura es %s con %s", ciudadMin, tempMin
		);

    System.out.println(respuestaMaxima);
    System.out.println(respuestaMinima);
  }
}
