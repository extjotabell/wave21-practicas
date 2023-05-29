package org.example;

public class MotoSocorrista implements Socorrer<Moto> {

  @Override
  public void socorrer(Moto v) {
    System.out.println("Soccorriendo a "+v);
  }
}
