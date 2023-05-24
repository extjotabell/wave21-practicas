package Clases;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private String apellido;
    private String dni;

    private List<Localizador> localizadores;

    public Cliente(String nombre, String apellido, String dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.localizadores = new ArrayList<>();
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizadores) {
        this.localizadores = localizadores;
    }

    public void agregarLocalizador(Localizador localizador){
        if (this.localizadores.size() > 2){
            // Aplico el descuento de 5% en futuras compras
            localizador.calcularTotal(0.95);
        }
        else{
            localizador.calcularTotal();
        }

        // Agrego localizador
        this.localizadores.add(localizador);
    }

    @Override
    public String toString() {
        return "DNI: " + dni + " - Nombre: " + nombre +" - Apellido: " + apellido;
    }

    public void imprimirLocalizador(int id) {
        // Me traigo el localizador correspondiente al id
        localizadores.stream()
                .filter(x -> x.getId() == id)
                .forEach(
                        x-> System.out.println(x.getTotal())
                );
    }

    public void imprimirLocalizadores(){
        localizadores.forEach(
                x-> System.out.println(x.getTotal())
        );
    }
}
