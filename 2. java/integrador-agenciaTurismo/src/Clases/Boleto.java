package Clases;

public class Boleto extends Reserva{
    private Integer precio;

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public Boleto(Integer idReserva, String fechaReserva, int precio) {
        super(idReserva, fechaReserva);
        this.precio = precio;
    }
}
