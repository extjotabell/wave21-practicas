package org.example;

public class Main {
  public static void main(String[] args) {
    Animal a = new Perro();
    Animal g = new Gato();
    Animal v = new Vaca();

    Granja.comerAnimal(a);
    Granja.comerAnimal(g);
    Granja.comerAnimal(v);
  }
}
