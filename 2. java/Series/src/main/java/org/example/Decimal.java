package org.example;

public class Decimal extends Prototipo<Double> {
  @Override
  public Double next() {
    return this.base+this.incremento*(++this.times);
  }

  @Override
  public void set(Double i) {
    this.incremento = i;
    this.base = this.times = 0d;
  }

  @Override
  public void reset(Double i) {
    this.base = i;
    this.times = 0d;
  }
}
