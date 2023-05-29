package org.example;

import java.util.Random;

public class Main {
  static String patenteMoto;
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

    char a = (char) r.nextInt(65, 90);
    char b = (char) r.nextInt(65, 90);
    char c = (char) r.nextInt(65, 90);
    int number = r.nextInt(100, 999);

    Main.patenteMoto = ""+a+b+c+" "+number;
    return new Moto(
      Math.floor(r.nextDouble(0, 300)),
      Math.floor(r.nextDouble(0, 300)), Math.round(Math.random()*10),
      Main.patenteMoto
    );
  }
  public static Auto generadorAutos() {
    Random  r = new Random();

    char a = (char) r.nextInt(65, 90);
    char b = (char) r.nextInt(65, 90);
    char c = (char) r.nextInt(65, 90);
    int number = r.nextInt(100, 999);

    return new Auto(
      Math.floor(r.nextDouble(0, 300)),
      Math.floor(r.nextDouble(0, 300)), Math.round(Math.random()*10),
     ""+a+b+c+" "+number
    );
  }
}