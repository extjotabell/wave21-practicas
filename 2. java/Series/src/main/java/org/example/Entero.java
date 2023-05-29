package org.example;

public class Entero extends Prototipo<Integer> {

  @Override
  public Integer next() {
    return this.base+this.incremento*(++this.times);
  }

  @Override
  public void set(Integer i) {
    this.incremento = i;
    this.base = this.times = 0;
  }

  @Override
  public void reset(Integer i) {
    this.base = i;
    this.times = 0;
  }
}
