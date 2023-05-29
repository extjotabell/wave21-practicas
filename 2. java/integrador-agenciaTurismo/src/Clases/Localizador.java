package Clases;

public class Localizador {
    private Integer idLocalizador;
    private Cliente turista;
    private Hotel hotel;
    private Comida comida;
    private Boleto boletos;
    private Transporte transporte;

    public Integer getIdLocalizador() {
        return idLocalizador;
    }

    public void setIdLocalizador(Integer idLocalizador) {
        this.idLocalizador = idLocalizador;
    }

    public Cliente getTurista() {
        return turista;
    }

    public void setTurista(Cliente turista) {
        this.turista = turista;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public Comida getComida() {
        return comida;
    }

    public void setComida(Comida comida) {
        this.comida = comida;
    }

    public Boleto getBoletos() {
        return boletos;
    }

    public void setBoletos(Boleto boletos) {
        this.boletos = boletos;
    }

    public Transporte getTransporte() {
        return transporte;
    }

    public void setTransporte(Transporte transporte) {
        this.transporte = transporte;
    }

    public Localizador(Integer idLocalizador, Cliente turista, Hotel hotel, Comida comida, Boleto boletos, Transporte transporte) {
        this.idLocalizador = idLocalizador;
        this.turista = turista;
        this.hotel = hotel;
        this.comida = comida;
        this.boletos = boletos;
        this.transporte = transporte;
    }

    public Localizador() {

    }

    public Integer calcularTotal(){
        
    }
}
