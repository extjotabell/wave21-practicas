package clases;

import clases.abstracts.Prototipe;

public class IntegerSeries extends Prototipe<Integer> {

    public IntegerSeries(Integer initailValue, Integer increment){
        this.value = initailValue;
        this.initialValue = initailValue;
        this.increment = increment;
    }
    @Override
    public Integer getNext() {
        this.value = this.value + this.increment;

        return value;
    }
}
