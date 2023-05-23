public class Inscripcion {

    private int id;
    private Categoria categoria;
    private Participante participante;
    private Double monto;

    public Inscripcion(int id, Categoria categoria, Participante participante) {
        this.id = id;
        this.categoria = categoria;
        this.participante = participante;
        if(categoria.getNombre().equals("chico")){
            if(participante.getEdad()<18) this.monto=1300.0;
            else this.monto=1500.0;
        }
        else if(categoria.getNombre().equals("medio")){
            if(participante.getEdad()<18) this.monto=2000.0;
            else this.monto=2300.0;
        } else{
            if(participante.getEdad()>18) this.monto=2800.0;
            else this.monto=0.0;
        }
    }

    public String imprimirInscripcion(){
        return "id:"+this.id+" categoria:"+categoria.getNombre()+" participante:"+participante.getNombre();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

}
