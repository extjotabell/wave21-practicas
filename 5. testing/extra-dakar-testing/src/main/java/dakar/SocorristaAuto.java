package dakar;

public class SocorristaAuto {

    private String nombre;
    private String dni;

    public SocorristaAuto(String nombre, String dni) {
        this.nombre = nombre;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


    public void socorrer(Auto auto){
        System.out.println("socorriendo auto: " + auto.getPatente());
    }
}
