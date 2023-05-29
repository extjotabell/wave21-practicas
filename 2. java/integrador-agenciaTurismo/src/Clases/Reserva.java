package Clases;

public class Reserva {
    private Integer idReserva;
    private String fechaReserva;

    public Integer getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Integer idReserva) {
        this.idReserva = idReserva;
    }

    public String getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    Reserva(Integer idReserva, String fechaReserva){
        this.fechaReserva = fechaReserva;
        this.idReserva = idReserva;
    }

}
