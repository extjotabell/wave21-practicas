package ejercicio01;

public class Clase1 extends Prototipo{

    public Clase1(double interval, double initialValue) {
        super(interval, initialValue);
    }

    public void printSerie(){
        System.out.println(Math.round(initialValue));
        double counter = initialValue;
        for (int i = 0; i < 10; i++){
            counter += interval;
            System.out.println(Math.round(counter));
        }
    }

    @Override
    public void reset() {
        this.interval = 0D;
        this.initialValue = 0D;
    }

    @Override
    public void setInterval(double value) {
        this.interval = value;
    }

    @Override
    public void setInitialValue(double value) {
        this.initialValue = value;
    }
}
