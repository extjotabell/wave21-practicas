package Clases;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private Integer id;
    private String nombre;
    private String apellido;

    List<Localizador> paquetes = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public List<Localizador> getPaquetes() {
        return paquetes;
    }

    public void setPaquetes(List<Localizador> paquetes) {
        this.paquetes = paquetes;
    }

    public Cliente(Integer id, String nombre, String apellido) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public void agregarPaquete(Localizador unPack){
        paquetes.add(unPack);
    }
    public Localizador buscarPaquetePorId(Integer idLoc){
        for(Localizador paquete: paquetes){
            if(paquete.getIdLocalizador() == idLoc){
                return paquete;
            }
        }
        return null;
    }
}
