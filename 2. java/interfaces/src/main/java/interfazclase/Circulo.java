package interfazclase;

public class Circulo implements Figura{
    public Circulo(double radio) {
        this.radio = radio;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    private double radio;

    @Override
    public double calcularArea() {
        return radio * PI * radio;
    }
}
