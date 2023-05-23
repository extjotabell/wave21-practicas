public class Inscripcion {

    int numero;
    Categoria categoria;
    Participante participante;
    double monto;

    public Inscripcion(int numero, Categoria categoria, Participante participante, double monto) {
        this.numero = numero;
        this.categoria = categoria;
        this.participante = participante;
        this.monto = monto;
    }
}
