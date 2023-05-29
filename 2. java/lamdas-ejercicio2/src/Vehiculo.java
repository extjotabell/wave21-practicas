public class Vehiculo {
    private String marca;
    private String modelo;
    private Integer precio;


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

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Vehiculo(String marca, String modelo, Integer precio) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
    }

    public Vehiculo() {

    }

    public void tostring(){
        System.out.println("marca: "+ this.marca +"\n"+
                            "modelo: "+ this.modelo + "\n"+
                            "precio: "+ this.precio
                );
    }
}
