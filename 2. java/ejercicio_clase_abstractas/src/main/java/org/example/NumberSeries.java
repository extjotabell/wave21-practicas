package org.example;

public abstract class NumberSeries<T extends Number> {
    protected T currentNumber;

    public abstract T getNext();

    public abstract void reset();

    public abstract void setInitial(T initial);
}
