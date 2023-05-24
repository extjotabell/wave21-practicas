package clases;

import clases.abstracts.Prototipe;

public class Series3 extends Prototipe {
    public Series3(){
        super();
    }

    @Override
    public int getNext() {
        int returnValue = this.value;
        this.value += 3;

        return returnValue;
    }
}
