public class Inscripcion {
    Participante participante;
    Circuito circuito;
    int monto;

    public Inscripcion(Participante participante, Circuito circuito) {
        this.participante = participante;
        this.circuito = circuito;
        this.monto = calcularMonto(participante, circuito);
    }

    private int calcularMonto(Participante participante, Circuito circuito) {
        return 0;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public Circuito getCircuito() {
        return circuito;
    }

    public void setCircuito(Circuito circuito) {
        this.circuito = circuito;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }
}
