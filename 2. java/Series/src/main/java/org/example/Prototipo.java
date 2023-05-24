package org.example;

public abstract class Prototipo<T extends Number> {
  private T base;
  private T incremento;
  private T last;

  abstract public T next();
  abstract public void reinicio(T i);
  abstract public void reset(T i);
}
