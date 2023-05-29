package org.example;

public class AutoSocorrista implements Socorrer<Auto> {
  @Override
  public void socorrer(Auto v) {
    System.out.println("Socorriendo a: "+v);
  }
}
