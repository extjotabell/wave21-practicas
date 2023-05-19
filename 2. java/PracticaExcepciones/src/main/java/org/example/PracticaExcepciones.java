package org.example;

import javax.sound.midi.SysexMessage;

public class PracticaExcepciones {
  private int a;
  private int b;

  public PracticaExcepciones(int a, int b) {
    this.a = a;
    this.b = b;
  }

  public double cociente() throws IllegalArgumentException {
    try {
      return b / a;
    } catch(Exception e) {
      throw new IllegalArgumentException("No se puede dividir por 0");
    }
  }
}
