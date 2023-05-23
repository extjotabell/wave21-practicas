package org.example;

public class Gato extends Carnivoro {

  @Override
  public void sonido() {
    System.out.println("Miau");
  }

  @Override
  public void comer() {
    System.out.println("Ñam ñam como carne como leon");
  }
}
