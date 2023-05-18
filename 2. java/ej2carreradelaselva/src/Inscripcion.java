public class Inscripcion {
    private Integer numInscripcion;
    private Categoria categoria;
    private Participante participante;
    private Double monto;

    public Inscripcion(Integer numInscripcion, Categoria categoria, Participante participante) {
        this.numInscripcion = numInscripcion;
        this.categoria = categoria;
        this.participante = participante;
        if(categoria.getNombre().equals("Circuito Chico")){
            if(participante.getEdad()<18){
                this.monto=1300d;
            }else{
                this.monto=1500d;
            }
        }else if(categoria.getNombre().equals("Circuito Medio")){
            if(participante.getEdad()<18){
                this.monto=2000d;
            }else{
                this.monto=2300d;
            }
        }else{
            if(participante.getEdad()<18){
                this.monto=0d;
            }else{
                this.monto=2800d;
            }
        }
    }

    public Integer getNumInscripcion() {
        return numInscripcion;
    }

    public void setNumInscripcion(Integer numInscripcion) {
        this.numInscripcion = numInscripcion;
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

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Inscripcion{" +
                "numInscripcion=" + numInscripcion +
                ", categoria=" + categoria +
                ", participante=" + participante +
                ", monto=" + monto +
                '}';
    }
}
