package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
  public static void main(String[] args) {
    final Persona genericPerson = new Persona();
    final Persona myBasicData = new Persona("Nahuel", 22);
    final Persona myLegalData = new Persona("Nahuel", 22, "11111111");
    final Persona myFullData = new Persona("Nahuel", 22, "11111111", 71f, 1.81f);

    final int estadoImc = myFullData.calcularImc();

    if(estadoImc == -1)
      System.out.println("Estas en mal estado(bajo peso)");
    else if(estadoImc == 0)
      System.out.println("Tenes buena salud(saludable)");
    else if(estadoImc == 1)
      System.out.println("Estas en mal estado(sobrepeso)");

    if(myFullData.esMayorDeEdad())
      System.out.println("Es mayor de edad");
    else
      System.out.println("Es menor de edad");

    System.out.println(myFullData.toString());
  }
}