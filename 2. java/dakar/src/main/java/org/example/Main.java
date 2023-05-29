package org.example;

import java.util.Random;

public class Main {
  static String patenteMoto;
  static final int ASCII_INIT = 65;
  static final int ASCII_END = 90;
  static final int LIMITE_VELOCIDAD = 300;

  public static void main(String[] args) {
    Carrera c = new Carrera(100, 2000, "Gran Patagonia", 10);
    Carrera cMuerte = new Carrera(200, 2000, "Gran Patagonia", 10);

    try {
      for (int i = 0; i < 5; i++) {
        Vehiculo v = Main.generadorAutos();
        c.altaVehiculo(v);
        cMuerte.altaVehiculo(v);
      }

      for (int i = 0; i < 5; i++) {
        Vehiculo v = Main.generadorMotos();
        c.altaVehiculo(v);
        cMuerte.altaVehiculo(v);
      }

      cMuerte.altaVehiculo(Main.generadorAutos());
    } catch (SinCupoException e) {
      e.printStackTrace();
      System.out.println(e.getMessage());
    }

    try {
      //c.socorrerAuto(Main.patenteMoto);
      c.socorrerMoto(Main.patenteMoto);
    } catch (VehiculoNotFoundException e) {
      e.printStackTrace();
      System.out.println("No se encontro el vehiculo");
    } finally {
      c.ganador();
      System.out.println("El ganador es: "+c.ganador());
      System.out.println("Listado: ");
      c.printVehiculos();
    }
  }

  public static Moto generadorMotos() {
    Random  r = new Random();

    char a = (char) r.nextInt(ASCII_INIT, ASCII_END);
    char b = (char) r.nextInt(ASCII_INIT, ASCII_END);
    char c = (char) r.nextInt(ASCII_INIT, ASCII_END);
    int number = r.nextInt(100, 999);

    String patente = Main.patenteMoto = ""+a+b+c+" "+number;

    return new Moto(
      Math.floor(r.nextDouble(0, LIMITE_VELOCIDAD)),
      Math.floor(r.nextDouble(0, LIMITE_VELOCIDAD)),
      Math.round(Math.random()*10),
      patente
    );
  }
  public static Auto generadorAutos() {
    Random  r = new Random();

    char a = (char) r.nextInt(ASCII_INIT, ASCII_END);
    char b = (char) r.nextInt(ASCII_INIT, ASCII_END);
    char c = (char) r.nextInt(ASCII_INIT, ASCII_END);
    int number = r.nextInt(100, 999);

    String patente = ""+a+b+c+" "+number;

    return new Auto(
      Math.floor(r.nextDouble(0, LIMITE_VELOCIDAD)),
      Math.floor(r.nextDouble(0, LIMITE_VELOCIDAD)),
      Math.round(Math.random()*10),
      patente
    );
  }
}
