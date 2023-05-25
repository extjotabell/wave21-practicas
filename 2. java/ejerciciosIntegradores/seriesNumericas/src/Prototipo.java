public abstract class Prototipo {
    private Number initialValue;
    private Number actualValue;

    public Prototipo(Number initialValue) {
        this.initialValue = initialValue;
        this.actualValue = initialValue;
    }


    public Number getValue() {
        return this.actualValue;
    }

    public void setActualValue(Number actualValue) {
        this.actualValue = actualValue;
    }

    public void reset(){
        this.actualValue = this.initialValue;
    }

    public void setInitialValue(Number initialValue){
        this.initialValue = initialValue;
    }

    public  abstract Number nextValue ();
}
