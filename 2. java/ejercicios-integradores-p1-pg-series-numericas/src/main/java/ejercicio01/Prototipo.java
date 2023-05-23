package ejercicio01;

public abstract class Prototipo {
    double interval;
    double initialValue;

    public Prototipo(double interval, double initialValue) {
        this.interval = interval;
        this.initialValue = initialValue;
    }

    public abstract void reset();

    public abstract void setInterval(double value);

    public abstract void setInitialValue(double value);
}
