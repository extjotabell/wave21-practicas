package com.bootcamp.wave21;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioLocalizador {

    private List<Localizador> localizadores;

    public RepositorioLocalizador(){
        localizadores = new ArrayList<>();
    }
    public void agregarLocalizador(Localizador loc){
        localizadores.add(loc);
    }

    public void eliminarLocalizador(Localizador loc){

    }



    public List<Localizador> getLocalizadores() {
        return localizadores;
    }

    public void setLocalizadores(List<Localizador> localizares) {
        this.localizadores = localizares;
    }



    public int cantidadReservasVendidas(){

        return 0;
    }



}
