public class Incripcion {
    private int numInscripcion;
    private Categoria categoria;
    private Participante participante;
    private int monto;

    public int getnumInscripcion() {
        return numInscripcion;
    }

    public void setnumInscripcion(int inscripcion) {
        this.numInscripcion = inscripcion;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Participante getParticipante() {
        return participante;
    }

    public void setParticipante(Participante participante) {
        this.participante = participante;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public Incripcion() {

    }
}
