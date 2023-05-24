package clases;

import clases.abstracts.Prototipe;

public class Series2 extends Prototipe {
    public Series2(){
        super();
    }

    @Override
    public int getNext() {
        int returnValue = this.value;
        this.value += 2;

        return returnValue;
    }
}
