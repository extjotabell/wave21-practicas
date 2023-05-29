package clases;

public class Boleto {
    private String numero;
    private Double total;

    public Boleto(String numero,Double total) {
        this.numero = numero;
        this.total=total;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
