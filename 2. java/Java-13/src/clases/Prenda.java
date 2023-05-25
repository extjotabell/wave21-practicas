package clases;

public class Prenda {
    private String marca;
    private String modelo;

    public Prenda(String marca, String modelo) {
        this.marca = marca;
        this.modelo = modelo;
    }

    @Override
    public String toString(){
        return new StringBuilder("Marca: ").append(this.marca).append(" - ")
                .append("Modelo: ").append(this.modelo)
                .toString();
    }
}
