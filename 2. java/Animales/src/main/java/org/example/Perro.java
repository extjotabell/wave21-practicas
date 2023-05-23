package org.example;

public class Perro extends Animal {
  @Override
  public void sonido() {
    System.out.println("Guauu");
  }

  @Override
  public void comer() {
    System.out.println("Muerdo carne cruda");
  }

}
