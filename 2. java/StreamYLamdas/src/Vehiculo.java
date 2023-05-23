public class Vehiculo {

    private String marca;
    private String modelo;
    private Integer costo;

    public Vehiculo(String marca, String modelo, Integer costo) {
        this.marca = marca;
        this.modelo = modelo;
        this.costo = costo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }

    //Clase tostring para imprimir los vehiculos
}
