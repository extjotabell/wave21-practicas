package clases.abstracts;

public abstract class Prototipe<T extends Number> {
    protected T value;
    protected T initialValue;
    protected T increment;

    public void init(){
        this.value = this.initialValue;
    }
    public void init(T initialValue) {
        this.initialValue   = initialValue;
        this.value          = initialValue;
    }

    public abstract T getNext();
}
