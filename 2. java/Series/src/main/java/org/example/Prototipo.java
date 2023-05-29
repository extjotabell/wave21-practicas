package org.example;

public abstract class Prototipo<T extends Number> {

  protected T base;
  protected T incremento;
  protected T times;

  abstract public T next();
  abstract public void set(T i);
  abstract public void reset(T i);
}
