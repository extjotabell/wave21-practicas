public class Participante {

    private int numeroParticipante;
    private int dni;
    private String nombre;
    private String apellido;
    private int edad;
    private int celular;
    private int numEmergencia;
    private String grupoSanguineo;
    private int categoria;

    public int getNumeroParticipante() {
        return numeroParticipante;
    }

    public void setNumeroParticipante(int numeroParticipante) {
        this.numeroParticipante = numeroParticipante;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getCelular() {
        return celular;
    }

    public void setCelular(int celular) {
        this.celular = celular;
    }

    public int getNumEmergencia() {
        return numEmergencia;
    }

    public void setNumEmergencia(int numEmergencia) {
        this.numEmergencia = numEmergencia;
    }

    public String getGrupoSanguineo() {
        return grupoSanguineo;
    }

    public void setGrupoSanguineo(String grupoSanguineo) {
        this.grupoSanguineo = grupoSanguineo;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    public Participante(int numeroParticipante, int dni, String nombre, String apellido, int edad, int celular, int numEmergencia, String grupoSanguineo, int categoria) {
        this.numeroParticipante = numeroParticipante;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.celular = celular;
        this.numEmergencia = numEmergencia;
        this.grupoSanguineo = grupoSanguineo;
        this.categoria = categoria;
    }
    public int calcularMonto(){
        int monto = 0;
        if(this.getCategoria() == 1 && this.getEdad() > 18){
            monto = 1500;
        } else if(this.getCategoria() == 1 && this.getEdad() < 18){
            monto = 1300;
        } else if(this.getCategoria() == 2 && this.getEdad() > 18) monto = 2300;
        if(this.getCategoria() == 2 && this.getEdad() < 18){
            monto = 2000;
        } else if(this.getCategoria() == 3 && this.getEdad() > 18 ){
            monto = 2800;
        } else if(this.getCategoria() == 3 && this.getEdad() < 18 ) {
            System.out.println("NO SE PERMITE MENORES PARA ESTA CATEGORIA\n");
            monto = -1;
        }

        return monto;
    }

}


