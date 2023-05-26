package agencia_turismo;

import java.util.ArrayList;
import java.util.List;

public class Cliente implements Identificable {
    private final String nombre;
    private final String apellido;
    private final int edad;
    private final String dni;
    private final List<Localizador> localizadores;
    private int id;

    public Cliente(int id, String nombre, String apellido, int edad, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.dni = dni;
        this.localizadores = new ArrayList<>();
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public int getEdad() {
        return edad;
    }

    public String getDni() {
        return dni;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void agregarLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }
}
