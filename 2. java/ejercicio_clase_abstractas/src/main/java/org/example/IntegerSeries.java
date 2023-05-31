package org.example;

public class IntegerSeries extends NumberSeries<Integer> {
    private int step;

    public IntegerSeries(int step) {
        this.step = step;
        this.currentNumber = 0;
    }

    @Override
    public Integer getNext() {
        this.currentNumber += this.step;
        return this.currentNumber;
    }

    @Override
    public void reset() {
        this.currentNumber = 0;
    }

    @Override
    public void setInitial(Integer initial) {
        this.currentNumber = initial;
    }
}
