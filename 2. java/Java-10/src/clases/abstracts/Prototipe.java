package clases.abstracts;

public abstract class Prototipe {
    protected int value;
    protected int initialValue;

    public Prototipe(){
        this.initialValue   = 0;
        this.value          = 0;
    }

    public void init(){
        this.value = this.initialValue;
    }
    public void init(int initialValue) {
        this.initialValue   = initialValue;
        this.value          = initialValue;
    }

    public abstract int getNext();
}
