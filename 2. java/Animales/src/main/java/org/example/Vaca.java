package org.example;

public class Vaca extends Hervivoro {

  @Override
  public void sonido() {
    System.out.println("Muuuuu");
  }

  @Override
  public void comer() {
    System.out.println("Pasto PASTOO");
  }
}
